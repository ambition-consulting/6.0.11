/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portal.tools;

import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.tools.servicebuilder.ServiceBuilder;
import com.liferay.portal.util.FileImpl;
import com.liferay.portal.xml.SAXReaderImpl;
import com.liferay.util.xml.DocUtil;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.AbstractJavaEntity;
import com.thoughtworks.qdox.model.Annotation;
import com.thoughtworks.qdox.model.DocletTag;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;
import com.thoughtworks.qdox.model.Type;

import jargs.gnu.CmdLineParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.DirectoryScanner;

/**
 * @author Brian Wing Shun Chan
 * @author Connor McKay
 */
public class JavadocFormatter {

	public static void main(String[] args) {
		try {
			new JavadocFormatter(args);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JavadocFormatter(String[] args) throws Exception {
		CmdLineParser cmdLineParser = new CmdLineParser();

		CmdLineParser.Option limitOption = cmdLineParser.addStringOption(
			"limit");
		CmdLineParser.Option initOption = cmdLineParser.addStringOption(
			"init");

		cmdLineParser.parse(args);

		String limit = (String)cmdLineParser.getOptionValue(limitOption);
		String init = (String)cmdLineParser.getOptionValue(initOption);

		if (!init.startsWith("$")) {
			_initializeMissingJavadocs = GetterUtil.getBoolean(init);
		}

		DirectoryScanner ds = new DirectoryScanner();

		ds.setBasedir(_basedir);
		ds.setExcludes(
			new String[] {
				"**\\classes\\**", "**\\portal-client\\**", "**\\tools\\**"
			});

		List<String> includes = new ArrayList<String>();

		if (Validator.isNotNull(limit) && !limit.startsWith("$")) {
			String[] limitArray = StringUtil.split(limit, "/");

			for (String curLimit : limitArray) {
				includes.add(
					"**\\" + StringUtil.replace(curLimit, ".", "\\") +
						"\\**\\*.java");
				includes.add("**\\" + curLimit + ".java");
			}
		}
		else {
			includes.add("**\\*.java");
		}

		ds.setIncludes(includes.toArray(new String[includes.size()]));

		ds.scan();

		String[] fileNames = ds.getIncludedFiles();

		for (String fileName : fileNames) {
			fileName = StringUtil.replace(fileName, "\\", "/");

			_format(fileName);
		}
	}

	private void _addClassCommentElement(
		Element rootElement, JavaClass javaClass) {

		Element commentElement = rootElement.addElement("comment");

		String comment = _getCDATA(javaClass);

		if (comment.startsWith("Copyright (c) 2000-2010 Liferay, Inc.")) {
			comment = StringPool.BLANK;
		}

		commentElement.addCDATA(comment);
	}

	private void _addDocletElements(
			Element parentElement, AbstractJavaEntity abstractJavaEntity,
			String name)
		throws Exception {

		DocletTag[] docletTags = abstractJavaEntity.getTagsByName(name);

		for (DocletTag docletTag : docletTags) {
			String value = docletTag.getValue();

			value = _trimMultilineText(value);

			value = StringUtil.replace(value, " </", "</");

			if (name.equals("author") || name.equals("see") ||
				name.equals("since") || name.equals("version")) {

				/*if (value.startsWith("Raymond Aug")) {
					value = new String(
						"Raymond Aug\u00c3\u00a9".getBytes(), StringPool.UTF8);
				}*/
			}

			Element element = parentElement.addElement(name);

			element.addCDATA(value);
		}

		if ((docletTags.length == 0) && name.equals("author")) {
			Element element = parentElement.addElement(name);

			element.addCDATA(ServiceBuilder.AUTHOR);
		}
	}

	private String _addDocletTags(
		Element parentElement, String[] names, String indent) {

		StringBuilder sb = new StringBuilder();

		int maxNameLength = 0;

		for (String name : names) {
			if (name.length() < maxNameLength) {
				continue;
			}

			List<Element> elements = parentElement.elements(name);

			for (Element element : elements) {
				Element commentElement = element.element("comment");

				String comment = null;

				if (commentElement != null) {
					comment = commentElement.getText();
				}
				else {
					comment = element.getText();
				}

				if (!name.equals("deprecated") && !_initializeMissingJavadocs &&
					Validator.isNull(comment)) {

					continue;
				}

				maxNameLength = name.length();

				break;
			}
		}

		int indentLength =_getIndentLength(indent) + maxNameLength;

		String maxNameIndent = "\t ";

		for (int i = 0; i < maxNameLength; i++) {
			maxNameIndent += " ";
		}

		maxNameIndent = StringUtil.replace(
			maxNameIndent, StringPool.FOUR_SPACES, "\t");

		for (String name : names) {
			String curNameIndent = " ";

			if (name.length() < maxNameLength) {
				int firstTab = 4 - (name.length() % 4);

				int delta = (maxNameLength + 1) - (name.length() + firstTab);

				if (delta == 0) {
					curNameIndent = "\t";
				}
				else if (delta < 0) {
					for (int i = 0; i < (maxNameLength - name.length()); i++) {
						curNameIndent += " ";
					}
				}
				else if (delta > 0) {
					curNameIndent = "\t";

					int numberOfTabs = delta / 4;

					if (numberOfTabs > 0) {
						for (int i = 0; i < numberOfTabs; i++) {
							curNameIndent += "\t";
						}
					}

					int numberOfSpaces = delta % 4;

					if (numberOfSpaces > 0) {
						for (int i = 0; i < numberOfSpaces; i++) {
							curNameIndent += " ";
						}
					}
				}
			}

			List<Element> elements = parentElement.elements(name);

			for (Element element : elements) {
				Element commentElement = element.element("comment");

				String comment = null;

				if (commentElement != null) {
					comment = commentElement.getText();
				}
				else {
					comment = element.getText();
				}

				if (!name.equals("deprecated") && !_initializeMissingJavadocs &&
					Validator.isNull(comment)) {

					continue;
				}

				sb.append(indent);
				sb.append(" * @");
				sb.append(name);

				if (Validator.isNotNull(comment) || (commentElement != null)) {
					sb.append(curNameIndent);
				}

				if (commentElement != null) {
					comment = element.elementText("name") + " " + comment;
				}

				comment = StringUtil.wrap(comment, 80 - indentLength - 5, "\n");

				comment = comment.trim();

				comment = StringUtil.replace(
					comment, "\n", "\n" + indent + " *" + maxNameIndent);

				while (comment.contains(" \n")) {
					comment = StringUtil.replace(comment, " \n", "\n");
				}

				while (comment.startsWith("\n")) {
					comment = comment.substring(1, comment.length());
				}

				sb.append(comment);
				sb.append("\n");
			}
		}

		return sb.toString();
	}

	private void _addFieldElement(Element rootElement, JavaField javaField)
		throws Exception {

		Element fieldElement = rootElement.addElement("field");

		DocUtil.add(fieldElement, "name", javaField.getName());

		Element commentElement = fieldElement.addElement("comment");

		commentElement.addCDATA(_getCDATA(javaField));

		_addDocletElements(fieldElement, javaField, "version");
		_addDocletElements(fieldElement, javaField, "see");
		_addDocletElements(fieldElement, javaField, "since");
		_addDocletElements(fieldElement, javaField, "deprecated");
	}

	private void _addMethodElement(Element rootElement, JavaMethod javaMethod)
		throws Exception {

		Element methodElement = rootElement.addElement("method");

		DocUtil.add(methodElement, "name", javaMethod.getName());

		Element commentElement = methodElement.addElement("comment");

		commentElement.addCDATA(_getCDATA(javaMethod));

		_addDocletElements(methodElement, javaMethod, "version");
		_addParamElements(methodElement, javaMethod);
		_addReturnElement(methodElement, javaMethod);
		_addThrowsElements(methodElement, javaMethod);
		_addDocletElements(methodElement, javaMethod, "see");
		_addDocletElements(methodElement, javaMethod, "since");
		_addDocletElements(methodElement, javaMethod, "deprecated");
	}

	private void _addParamElement(
		Element methodElement, JavaParameter javaParameter,
		DocletTag[] paramDocletTags) {

		String name = javaParameter.getName();
		String type = javaParameter.getType().getValue();
		String value = null;

		for (DocletTag paramDocletTag : paramDocletTags) {
			String curValue = paramDocletTag.getValue();

			if (!curValue.startsWith(name)) {
				continue;
			}
			else {
				value = curValue;

				break;
			}
		}

		Element paramElement = methodElement.addElement("param");

		DocUtil.add(paramElement, "name", name);
		DocUtil.add(paramElement, "type", type);

		if (value != null) {
			value = value.substring(name.length());
		}

		value = _trimMultilineText(value);

		Element commentElement = paramElement.addElement("comment");

		commentElement.addCDATA(value);
	}

	private void _addParamElements(
		Element methodElement, JavaMethod javaMethod) {

		JavaParameter[] javaParameters = javaMethod.getParameters();

		DocletTag[] paramDocletTags = javaMethod.getTagsByName("param");

		for (JavaParameter javaParameter : javaParameters) {
			_addParamElement(methodElement, javaParameter, paramDocletTags);
		}
	}

	private void _addReturnElement(
			Element methodElement, JavaMethod javaMethod)
		throws Exception {

		Type returns = javaMethod.getReturns();

		if ((returns == null) || returns.getValue().equals("void")) {
			return;
		}

		_addDocletElements(methodElement, javaMethod, "return");
	}

	private void _addThrowsElement(
		Element methodElement, Type exception, DocletTag[] throwsDocletTags) {

		String name = exception.getJavaClass().getName();
		String value = null;

		for (DocletTag throwsDocletTag : throwsDocletTags) {
			String curValue = throwsDocletTag.getValue();

			if (!curValue.startsWith(name)) {
				continue;
			}
			else {
				value = curValue;

				break;
			}
		}

		Element throwsElement = methodElement.addElement("throws");

		DocUtil.add(throwsElement, "name", name);
		DocUtil.add(throwsElement, "type", exception.getValue());

		if (value != null) {
			value = value.substring(name.length());
		}

		value = _trimMultilineText(value);

		Element commentElement = throwsElement.addElement("comment");

		commentElement.addCDATA(_getCDATA(value));

	}

	private void _addThrowsElements(
		Element methodElement, JavaMethod javaMethod) {

		Type[] exceptions = javaMethod.getExceptions();

		DocletTag[] throwsDocletTags = javaMethod.getTagsByName("throws");

		for (Type exception : exceptions) {
			_addThrowsElement(methodElement, exception, throwsDocletTags);
		}
	}

	private String _getCDATA(AbstractJavaEntity abstractJavaEntity) {
		return _getCDATA(abstractJavaEntity.getComment());
	}

	private String _getCDATA(String cdata) {
		if (cdata == null) {
			return StringPool.BLANK;
		}

		cdata = cdata.replaceAll(
			"(?s)\\s*<(p|pre|[ou]l)>\\s*(.*?)\\s*</\\1>\\s*",
			"\n\n<$1>\n$2\n</$1>\n\n");
		cdata = cdata.replaceAll(
			"(?s)\\s*<li>\\s*(.*?)\\s*</li>\\s*", "\n<li>\n$1\n</li>\n");
		cdata = StringUtil.replace(cdata, "</li>\n\n<li>", "</li>\n<li>");
		cdata = cdata.replaceAll("\n\\s+\n", "\n\n");
		cdata = cdata.replaceAll(" +", " ");

		// Trim whitespace inside paragraph tags or in the first paragraph

		Pattern pattern = Pattern.compile(
			"(^.*?(?=\n\n|$)+|(?<=<p>\n).*?(?=\n</p>))", Pattern.DOTALL);

		Matcher matcher = pattern.matcher(cdata);

		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {
			String trimmed = _trimMultilineText(matcher.group());

			matcher.appendReplacement(sb, trimmed);
		}

		matcher.appendTail(sb);

		cdata = sb.toString();

		return cdata.trim();
	}

	private String _getFieldKey(Element fieldElement) {
		return fieldElement.elementText("name");
	}

	private String _getFieldKey(JavaField javaField) {
		return javaField.getName();
	}

	private int _getIndentLength(String indent) {
		int indentLength = 0;

		for (char c : indent.toCharArray()) {
			if (c == '\t') {
				indentLength = indentLength + 4;
			}
			else {
				indentLength++;
			}
		}

		return indentLength;
	}

	private JavaClass _getJavaClass(String fileName, Reader reader)
		throws Exception {

		int pos = fileName.indexOf("src/");

		if (pos == -1) {
			pos = fileName.indexOf("test/");
		}

		if (pos == -1) {
			throw new RuntimeException(fileName);
		}

		pos = fileName.indexOf("/", pos);

		String srcFile = fileName.substring(pos + 1, fileName.length());
		String className = StringUtil.replace(
			srcFile.substring(0, srcFile.length() - 5), "/", ".");

		JavaDocBuilder builder = new JavaDocBuilder();

		if (reader == null) {
			File file = new File(fileName);

			if (!file.exists()) {
				return null;
			}

			builder.addSource(file);
		}
		else {
			builder.addSource(reader);
		}

		return builder.getClassByName(className);
	}

	private String _getJavaClassComment(
		Element rootElement, JavaClass javaClass) {

		StringBuilder sb = new StringBuilder();

		String indent = StringPool.BLANK;

		sb.append("/**\n");

		String comment = rootElement.elementText("comment");

		if (_initializeMissingJavadocs || Validator.isNotNull(comment)) {
			sb.append(_wrapText(comment, indent));
		}

		String docletTags = _addDocletTags(
			rootElement,
			new String[] {
				"author", "version", "see", "since", "serial", "deprecated"
			},
			indent);

		if (docletTags.length() > 0) {
			if (_initializeMissingJavadocs || Validator.isNotNull(comment)) {
				sb.append(" *\n");
			}

			sb.append(docletTags);
		}

		sb.append(" */\n");

		return sb.toString();
	}

	private Document _getJavadocDocument(JavaClass javaClass) throws Exception {
		Element rootElement = _saxReaderUtil.createElement("javadoc");

		Document document = _saxReaderUtil.createDocument(rootElement);

		DocUtil.add(rootElement, "name", javaClass.getName());
		DocUtil.add(rootElement, "type", javaClass.getFullyQualifiedName());

		_addClassCommentElement(rootElement, javaClass);
		_addDocletElements(rootElement, javaClass, "author");
		_addDocletElements(rootElement, javaClass, "version");
		_addDocletElements(rootElement, javaClass, "see");
		_addDocletElements(rootElement, javaClass, "since");
		_addDocletElements(rootElement, javaClass, "serial");
		_addDocletElements(rootElement, javaClass, "deprecated");

		JavaMethod[] javaMethods = javaClass.getMethods();

		for (JavaMethod javaMethod : javaMethods) {
			_addMethodElement(rootElement, javaMethod);
		}

		JavaField[] javaFields = javaClass.getFields();

		for (JavaField javaField : javaFields) {
			_addFieldElement(rootElement, javaField);
		}

		return document;
	}

	private String _getJavaFieldComment(
		String[] lines, Map<String, Element> fieldElementsMap,
		JavaField javaField) {

		String fieldKey = _getFieldKey(javaField);

		Element fieldElement = fieldElementsMap.get(fieldKey);

		if (fieldElement == null) {
			return null;
		}

		String line = lines[javaField.getLineNumber() - 1];

		String indent = StringPool.BLANK;

		for (char c : line.toCharArray()) {
			if (Character.isWhitespace(c)) {
				indent += c;
			}
			else {
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(indent);
		sb.append("/**\n");

		String comment = fieldElement.elementText("comment");

		if (_initializeMissingJavadocs || Validator.isNotNull(comment)) {
			sb.append(_wrapText(comment, indent));
		}

		String docletTags = _addDocletTags(
			fieldElement,
			new String[] {"version", "see", "since", "deprecated"}, indent);

		if (docletTags.length() > 0) {
			if (_initializeMissingJavadocs || Validator.isNotNull(comment)) {
				sb.append(indent);
				sb.append(" *\n");
			}

			sb.append(docletTags);
		}

		sb.append(indent);
		sb.append(" */\n");

		if (!_initializeMissingJavadocs && Validator.isNull(comment) &&
			Validator.isNull(docletTags)) {

			return null;
		}

		return sb.toString();
	}

	private String _getJavaMethodComment(
		String[] lines, Map<String, Element> methodElementsMap,
		JavaMethod javaMethod) {

		String methodKey = _getMethodKey(javaMethod);

		Element methodElement = methodElementsMap.get(methodKey);

		if (methodElement == null) {
			return null;
		}

		String line = lines[javaMethod.getLineNumber() - 1];

		String indent = StringPool.BLANK;

		for (char c : line.toCharArray()) {
			if (Character.isWhitespace(c)) {
				indent += c;
			}
			else {
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(indent);
		sb.append("/**\n");

		String comment = methodElement.elementText("comment");

		if (_initializeMissingJavadocs || Validator.isNotNull(comment)) {
			sb.append(_wrapText(comment, indent));
		}

		String docletTags = _addDocletTags(
			methodElement,
			new String[] {
				"version", "param", "return", "throws", "see", "since",
				"deprecated"
			},
			indent);

		if (docletTags.length() > 0) {
			if (_initializeMissingJavadocs || Validator.isNotNull(comment)) {
				sb.append(indent);
				sb.append(" *\n");
			}

			sb.append(docletTags);
		}

		sb.append(indent);
		sb.append(" */\n");

		if (!_initializeMissingJavadocs && Validator.isNull(comment) &&
			Validator.isNull(docletTags)) {

			return null;
		}

		return sb.toString();
	}

	private String _getMethodKey(Element methodElement) {
		StringBuilder sb = new StringBuilder();

		sb.append(methodElement.elementText("name"));
		sb.append("(");

		List<Element> paramElements = methodElement.elements("param");

		for (Element paramElement : paramElements) {
			sb.append(paramElement.elementText("name"));
			sb.append("|");
			sb.append(paramElement.elementText("type"));
			sb.append(",");
		}

		sb.append(")");

		return sb.toString();
	}

	private String _getMethodKey(JavaMethod javaMethod) {
		StringBuilder sb = new StringBuilder();

		sb.append(javaMethod.getName());
		sb.append("(");

		JavaParameter[] javaParameters = javaMethod.getParameters();

		for (JavaParameter javaParameter : javaParameters) {
			sb.append(javaParameter.getName());
			sb.append("|");
			sb.append(javaParameter.getType().getValue());
			sb.append(",");
		}

		sb.append(")");

		return sb.toString();
	}

	private boolean _isGenerated(String content) {
		if (content.contains("* @generated")) {
			return true;
		}
		else {
			return false;
		}
	}

	private String _removeJavadocFromJava(
		JavaClass javaClass, String content) {

		Set<Integer> lineNumbers = new HashSet<Integer>();

		lineNumbers.add(_getJavaClassLineNumber(javaClass));

		JavaMethod[] javaMethods = javaClass.getMethods();

		for (JavaMethod javaMethod : javaMethods) {
			lineNumbers.add(javaMethod.getLineNumber());
		}

		JavaField[] javaFields = javaClass.getFields();

		for (JavaField javaField : javaFields) {
			lineNumbers.add(javaField.getLineNumber());
		}

		String[] lines = StringUtil.split(content, "\n");

		for (int lineNumber : lineNumbers) {
			if (lineNumber == 0) {
				continue;
			}

			int pos = lineNumber - 2;

			String line = lines[pos].trim();

			if (line.endsWith("*/")) {
				while (true) {
					lines[pos] = null;

					if (line.startsWith("/**")) {
						break;
					}

					line = lines[--pos].trim();
				}
			}
		}

		StringBuilder sb = new StringBuilder(content.length());

		for (String line : lines) {
			if (line != null) {
				sb.append(line);
				sb.append("\n");
			}
		}

		return sb.toString().trim();
	}

	private void _format(String fileName) throws Exception {
		FileInputStream fis = new FileInputStream(
			new File(_basedir + fileName));

		byte[] bytes = new byte[fis.available()];

		fis.read(bytes);

		fis.close();

		String originalContent = new String(bytes);

		if (!fileName.endsWith("JavadocFormatter.java") &&
			_isGenerated(originalContent)) {

			return;
		}

		JavaClass javaClass = _getJavaClass(
			fileName, new UnsyncStringReader(originalContent));

		String javadocLessContent = _removeJavadocFromJava(
			javaClass, originalContent);

		Document document = _getJavadocDocument(javaClass);

		_updateJavaFromDocument(
			fileName, originalContent, javadocLessContent, document);
	}

	private String _formatInlines(String text) {

		// Wrap special constants in code tags

		text = text.replaceAll(
			"(?i)(?<!<code>)(null|false|true)", "<code>$1</code>");

		return text;
	}

	private int _getJavaClassLineNumber(JavaClass javaClass) {
		int lineNumber = javaClass.getLineNumber();

		Annotation[] annotations = javaClass.getAnnotations();

		if (annotations.length == 0) {
			return lineNumber;
		}

		for (Annotation annotation : annotations) {
			int annotationLineNumber = annotation.getLineNumber();

			if (annotation.getPropertyMap().isEmpty()) {
				annotationLineNumber--;
			}

			if (annotationLineNumber < lineNumber) {
				lineNumber = annotationLineNumber;
			}
		}

		return lineNumber;
	}

	private String _trimMultilineText(String text) {
		String[] textArray = StringUtil.split(text, "\n");

		for (int i = 0; i < textArray.length; i++) {
			textArray[i] = textArray[i].trim();
		}

		return StringUtil.merge(textArray, " ");
	}

	private void _updateJavaFromDocument(
			String fileName, String originalContent, String javadocLessContent,
			Document document)
		throws Exception {

		String[] lines = StringUtil.split(javadocLessContent, "\n");

		JavaClass javaClass = _getJavaClass(
			fileName, new UnsyncStringReader(javadocLessContent));

		Element rootElement = document.getRootElement();

		Map<Integer, String> commentsMap = new TreeMap<Integer, String>();

		commentsMap.put(
			_getJavaClassLineNumber(javaClass),
			_getJavaClassComment(rootElement, javaClass));

		Map<String, Element> methodElementsMap = new HashMap<String, Element>();

		List<Element> methodElements = rootElement.elements("method");

		for (Element methodElement : methodElements) {
			String methodKey = _getMethodKey(methodElement);

			methodElementsMap.put(methodKey, methodElement);
		}

		JavaMethod[] javaMethods = javaClass.getMethods();

		for (JavaMethod javaMethod : javaMethods) {
			if (commentsMap.containsKey(javaMethod.getLineNumber())) {
				continue;
			}

			commentsMap.put(
				javaMethod.getLineNumber(),
				_getJavaMethodComment(lines, methodElementsMap, javaMethod));
		}

		Map<String, Element> fieldElementsMap = new HashMap<String, Element>();

		List<Element> fieldElements = rootElement.elements("field");

		for (Element fieldElement : fieldElements) {
			String fieldKey = _getFieldKey(fieldElement);

			fieldElementsMap.put(fieldKey, fieldElement);
		}

		JavaField[] javaFields = javaClass.getFields();

		for (JavaField javaField : javaFields) {
			if (commentsMap.containsKey(javaField.getLineNumber())) {
				continue;
			}

			commentsMap.put(
				javaField.getLineNumber(),
				_getJavaFieldComment(lines, fieldElementsMap, javaField));
		}

		StringBuilder sb = new StringBuilder(javadocLessContent.length());

		for (int lineNumber = 1; lineNumber <= lines.length; lineNumber++) {
			String line = lines[lineNumber - 1];

			String comments = commentsMap.get(lineNumber);

			if (comments != null) {
				sb.append(comments);
			}

			sb.append(line);
			sb.append("\n");
		}

		String formattedContent = sb.toString().trim();

		if (!originalContent.equals(formattedContent)) {
			File file = new File(_basedir + fileName);

			_fileUtil.write(file, formattedContent.getBytes());

			System.out.println("Writing " + file);
		}
	}

	private String _wrapText(String text, String indent) {
		int indentLength = _getIndentLength(indent);

		// Do not wrap text inside <pre>

		if (text.contains("<pre>")) {
			Pattern pattern = Pattern.compile(
				"(?<=^|</pre>).+?(?=$|<pre>)", Pattern.DOTALL);

			Matcher matcher = pattern.matcher(text);

			StringBuffer sb = new StringBuffer();

			while (matcher.find()) {
				String wrapped = _formatInlines(matcher.group());

				wrapped = StringUtil.wrap(
					wrapped, 80 - indentLength - 3, "\n");

				matcher.appendReplacement(sb, wrapped);
			}

			matcher.appendTail(sb);

			sb.append("\n");

			text = sb.toString();
		}
		else {
			text = _formatInlines(text);

			text = StringUtil.wrap(text, 80 - indentLength - 3, "\n");
		}

		text = text.replaceAll("(?m)^", indent + " * ");
		text = text.replaceAll("(?m) +$", StringPool.BLANK);

		return text;
	}

	private static FileImpl _fileUtil = FileImpl.getInstance();
	private static SAXReaderImpl _saxReaderUtil = SAXReaderImpl.getInstance();

	private String _basedir = "./";
	private boolean _initializeMissingJavadocs;

}