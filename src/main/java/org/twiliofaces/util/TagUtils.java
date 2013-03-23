/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.twiliofaces.util;

import java.io.IOException;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class TagUtils {

	public static void addAttribute(FacesContext context,
			Map<String, Object> attributes, String key) throws IOException {
		String value = (String) attributes.get(key);
		if (value != null && !value.isEmpty())
			context.getResponseWriter().writeAttribute(key, value, null);
	}

	public static void addText(FacesContext context,
			Map<String, Object> attributes, String key) throws IOException {
		String value = (String) attributes.get(key);
		if (value != null && !value.isEmpty())
			context.getResponseWriter().writeText(value, null);
	}

	public static void start(FacesContext context, String tag)
			throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.startElement(tag, null);
	}

	public static void end(FacesContext context, String tag) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		responseWriter.endElement(tag);
	}
}
