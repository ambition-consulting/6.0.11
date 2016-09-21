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

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.tools.servicebuilder.ServiceBuilder;
import com.liferay.portal.util.FileImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.DirectoryScanner;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradeTableBuilder {

	public static void main(String[] args) {
		try {
			new UpgradeTableBuilder(args[0]);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UpgradeTableBuilder(String upgradeTableDir) throws Exception {
		DirectoryScanner ds = new DirectoryScanner();

		ds.setBasedir(".");
		ds.setIncludes(new String[] {"**\\upgrade\\v**\\util\\*Table.java"});

		ds.scan();

		String[] fileNames = ds.getIncludedFiles();

		for (String fileName : fileNames) {
			fileName = StringUtil.replace(fileName, "\\", "/");

			int x = fileName.indexOf("upgrade/v");
			int y = fileName.indexOf("/util", x);

			String version = StringUtil.replace(
				fileName.substring(x + 9, y), "_", ".");

			String upgradeFileVersion = version;

			int z = upgradeFileVersion.indexOf(".to.");

			if (z != -1) {
				upgradeFileVersion = upgradeFileVersion.substring(z + 4);
			}

			x = fileName.indexOf("/", y + 1);
			y = fileName.indexOf("Table.java", x);

			String upgradeFileName =
				upgradeTableDir + "/" + upgradeFileVersion + "/" +
					fileName.substring(x, y) + "ModelImpl.java";

			if (!_fileUtil.exists(upgradeFileName)) {
				upgradeFileName = _findUpgradeFileName(
					fileName.substring(x, y));

				if (upgradeFileName == null) {
					continue;
				}
			}

			String content = _fileUtil.read(upgradeFileName);

			String packagePath =
				"com.liferay.portal.upgrade.v" +
					StringUtil.replace(version, ".", "_") + ".util";
			String className = fileName.substring(x + 1, y) + "Table";

			String author = _getAuthor(fileName);

			String[] addIndexes = _getAddIndexes(
				upgradeTableDir + "/" + upgradeFileVersion + "/indexes.sql",
				fileName.substring(x + 1, y));

			content = _getContent(
				packagePath, className, content, author, addIndexes);

			_fileUtil.write(fileName, content);
		}
	}

	private String _findUpgradeFileName(String modelName) {
		DirectoryScanner ds = new DirectoryScanner();

		ds.setBasedir(".");
		ds.setIncludes(new String[] {"**\\" + modelName + "ModelImpl.java"});

		ds.scan();

		String[] fileNames = ds.getIncludedFiles();

		if (fileNames.length > 0) {
			return fileNames[0];
		}
		else {
			return null;
		}
	}

	private String[] _getAddIndexes(String indexesFileName, String tableName)
		throws Exception {

		List<String> addIndexes = new ArrayList<String>();

		File indexesFile = new File(indexesFileName);

		if (!indexesFile.exists()) {
			indexesFile = new File("../sql/indexes.sql");
		}

		UnsyncBufferedReader unsyncBufferedReader = new UnsyncBufferedReader(
			new InputStreamReader(new FileInputStream(indexesFile)));

		String line = null;

		while ((line = unsyncBufferedReader.readLine()) != null) {
			if (line.contains(" on " + tableName + " (") ||
				line.contains(" on " + tableName + "_ (")) {

				String sql = line.trim();

				if (sql.endsWith(";")) {
					sql = sql.substring(0, sql.length() - 1);
				}

				addIndexes.add(sql);
			}
		}

		unsyncBufferedReader.close();

		return addIndexes.toArray(new String[addIndexes.size()]);
	}

	private String _getAuthor(String fileName) throws Exception {
		if (_fileUtil.exists(fileName)) {
			String content = _fileUtil.read(fileName);

			int x = content.indexOf("* @author ");

			if (x != -1) {
				int y = content.indexOf("*", x + 1);

				if (y != -1) {
					return content.substring(x + 10, y).trim();
				}
			}
		}

		return ServiceBuilder.AUTHOR;
	}

	private String _getContent(
			String packagePath, String className, String content, String author,
			String[] addIndexes)
		throws Exception {

		int x = content.indexOf("public static final String TABLE_NAME =");

		if (x == -1) {
			x = content.indexOf("public static String TABLE_NAME =");
		}

		int y = content.indexOf("public static final String TABLE_SQL_DROP =");

		if (y == -1) {
			y = content.indexOf("public static String TABLE_SQL_DROP =");
		}

		y = content.indexOf(";", y);

		content = content.substring(x, y + 1);

		content = StringUtil.replace(
			content,
			new String[] {
				"\t", "{ \"", ") }"
			},
			new String[] {
				"", "{\"", ")}"
			});

		while (content.contains("\n\n")) {
			content = StringUtil.replace(content, "\n\n", "\n");
		}

		StringBundler sb = new StringBundler();

		sb.append(_fileUtil.read("../copyright.txt"));

		sb.append("\n\npackage ");
		sb.append(packagePath);
		sb.append(";\n\n");

		sb.append("import java.sql.Types;\n\n");

		sb.append("/**\n");
		sb.append(" * @author\t  ");
		sb.append(author);
		sb.append("\n");
		sb.append(" * @generated\n");
		sb.append(" */\n");
		sb.append("public class ");
		sb.append(className);
		sb.append(" {\n\n");

		String[] lines = StringUtil.split(content, "\n");

		for (String line : lines) {
			if (line.startsWith("public static") ||
				line.startsWith("};")) {

				sb.append("\t");
			}
			else if (line.startsWith("{\"")) {
				sb.append("\t\t");
			}

			sb.append(line);
			sb.append("\n");

			if (line.endsWith(";")) {
				sb.append("\n");
			}
		}

		sb.append("\tpublic static final String[] TABLE_SQL_ADD_INDEXES = {\n");

		for (int i = 0; i < addIndexes.length; i++) {
			String addIndex = addIndexes[i];

			sb.append("\t\t\"");
			sb.append(addIndex);
			sb.append("\"");

			if ((i + 1) < addIndexes.length) {
				sb.append(",");
			}

			sb.append("\n");
		}

		sb.append("\t};\n\n");

		sb.append("}");

		return sb.toString();
	}

	private static FileImpl _fileUtil = FileImpl.getInstance();

}