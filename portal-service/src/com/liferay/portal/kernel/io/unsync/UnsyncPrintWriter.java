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

package com.liferay.portal.kernel.io.unsync;

import com.liferay.portal.kernel.io.OutputStreamWriter;
import com.liferay.portal.kernel.util.StringPool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

import java.util.Formatter;
import java.util.Locale;

/**
 * <p>
 * See http://issues.liferay.com/browse/LPS-6648.
 * </p>
 *
 * @author Shuyang Zhou
 */
public class UnsyncPrintWriter extends PrintWriter {

	public UnsyncPrintWriter(File file) throws IOException {
		this(new FileWriter(file));
	}

	public UnsyncPrintWriter(File file, String csn)
		throws FileNotFoundException {

		this(new OutputStreamWriter(new FileOutputStream(file), csn));
	}

	public UnsyncPrintWriter(OutputStream outputStream) {
		this(new OutputStreamWriter(outputStream));
	}

	public UnsyncPrintWriter(String fileName) throws IOException {
		this(new FileWriter(fileName));
	}

	public UnsyncPrintWriter(String fileName, String csn)
		throws FileNotFoundException {

		this(new OutputStreamWriter(new FileOutputStream(fileName), csn));
	}

	public UnsyncPrintWriter(Writer writer) {
		super(writer);

		_writer = writer;
	}

	public PrintWriter append(char c) {
		write(c);

		return this;
	}

	public PrintWriter append(CharSequence charSequence) {
		if (charSequence == null) {
			write(StringPool.NULL);
		}
		else {
			write(charSequence.toString());
		}

		return this;
	}

	public PrintWriter append(CharSequence charSequence, int start, int end) {
		if (charSequence == null) {
			charSequence = StringPool.NULL;
		}

		write(charSequence.subSequence(start, end).toString());

		return this;
	}

	public boolean checkError() {
		if (_writer != null) {
			flush();
		}

		return _hasError;
	}

	public void close() {
		try {
			if (_writer == null) {
				return;
			}

			_writer.close();

			_writer = null;
		}
		catch (IOException ioe) {
			_hasError = true;
		}
	}

	public void flush() {
		if (_writer == null) {
			_hasError = true;
		}
		else {
			try {
				_writer.flush();
			}
			catch (IOException ioe) {
				_hasError = true;
			}
		}
	}

	public PrintWriter format(
		Locale locale, String format, Object... arguments) {

		if (_writer == null) {
			_hasError = true;
		}
		else {
			if ((_formatter == null) || (_formatter.locale() != locale)) {
				_formatter = new Formatter(this, locale);
			}

			_formatter.format(locale, format, arguments);
		}

		return this;
	}

	public PrintWriter format(String format, Object... arguments) {
		return format(Locale.getDefault(), format, arguments);
	}

	public void print(boolean b) {
		if (b) {
			write(StringPool.TRUE);
		}
		else {
			write(StringPool.FALSE);
		}
	}

	public void print(char c) {
		write(c);
	}

	public void print(char[] chars) {
		write(chars);
	}

	public void print(double d) {
		write(String.valueOf(d));
	}

	public void print(float f) {
		write(String.valueOf(f));
	}

	public void print(int i) {
		write(String.valueOf(i));
	}

	public void print(long l) {
		write(String.valueOf(l));
	}

	public void print(Object object) {
		write(String.valueOf(object));
	}

	public void print(String string) {
		if (string == null) {
			string = StringPool.NULL;
		}

		write(string);
	}

	public PrintWriter printf(
		Locale locale, String format, Object... arguments) {

		return format(locale, format, arguments);
	}

	public PrintWriter printf(String format, Object... arguments) {
		return format(format, arguments);
	}

	public void println() {
		if (_writer == null) {
			_hasError = true;
		}
		else {
			try {
				_writer.write(_LINE_SEPARATOR);
			}
			catch (InterruptedIOException iioe) {
				Thread currentThread = Thread.currentThread();

				currentThread.interrupt();
			}
			catch (IOException ioe) {
				_hasError = true;
			}
		}
	}

	public void println(boolean b) {
		print(b);
		println();
	}

	public void println(char c) {
		print(c);
		println();
	}

	public void println(char[] chars) {
		print(chars);
		println();
	}

	public void println(double d) {
		print(d);
		println();
	}

	public void println(float f) {
		print(f);
		println();
	}

	public void println(int i) {
		print(i);
		println();
	}

	public void println(long l) {
		print(l);
		println();
	}

	public void println(Object object) {
		print(object);
		println();
	}

	public void println(String string) {
		print(string);
		println();
	}

	public void write(char[] chars) {
		write(chars, 0, chars.length);
	}

	public void write(char[] chars, int offset, int length) {
		if (_writer == null) {
			_hasError = true;
		}
		else {
			try {
				_writer.write(chars, offset, length);
			}
			catch (InterruptedIOException iioe) {
				Thread currentThread = Thread.currentThread();

				currentThread.interrupt();
			}
			catch (IOException ioe) {
				_hasError = true;
			}
		}
	}

	public void write(int c) {
		if (_writer == null) {
			_hasError = true;
		}
		else {
			try {
				_writer.write(c);
			}
			catch (InterruptedIOException iioe) {
				Thread currentThread = Thread.currentThread();

				currentThread.interrupt();
			}
			catch (IOException ioe) {
				_hasError = true;
			}
		}
	}

	public void write(String string) {
		if (_writer == null) {
			_hasError = true;
		}
		else {
			try {
				_writer.write(string);
			}
			catch (InterruptedIOException iioe) {
				Thread currentThread = Thread.currentThread();

				currentThread.interrupt();
			}
			catch (IOException ioe) {
				_hasError = true;
			}
		}
	}

	public void write(String string, int offset, int length) {
		if (_writer == null) {
			_hasError = true;
		}
		else {
			try {
				_writer.write(string, offset, length);
			}
			catch (InterruptedIOException iioe) {
				Thread currentThread = Thread.currentThread();

				currentThread.interrupt();
			}
			catch (IOException ioe) {
				_hasError = true;
			}
		}
	}

	private static String _LINE_SEPARATOR = System.getProperty(
		"line.separator");

	private Formatter _formatter;
	private boolean _hasError;
	private Writer _writer;

}