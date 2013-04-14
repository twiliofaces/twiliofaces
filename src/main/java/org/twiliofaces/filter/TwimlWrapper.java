package org.twiliofaces.filter;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class TwimlWrapper extends HttpServletResponseWrapper {
	private CharArrayWriter writer;

	public TwimlWrapper(HttpServletResponse response) {
		super(response);
		writer = new CharArrayWriter();
	}

	public PrintWriter getWriter() {
		return (new PrintWriter(writer));
	}

	public String getTwiml() {
		return writer.toString();
	}

	public String toString() {
		return writer.toString();
	}

	public char[] toCharArray() {
		return (writer.toCharArray());
	}

}