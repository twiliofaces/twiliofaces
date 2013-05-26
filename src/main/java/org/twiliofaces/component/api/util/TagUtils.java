/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.component.api.util;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class TagUtils
{

   public static void addAttribute(FacesContext context,
            Map<String, Object> attributes, String key) throws IOException
   {
      String value = (String) attributes.get(key);
      if (value != null && !value.isEmpty())
         context.getResponseWriter().writeAttribute(key, value, null);
   }

   public static void addSingleAttribute(FacesContext context, String key,
            String value) throws IOException
   {
      if (value != null && !value.isEmpty())
         context.getResponseWriter().writeAttribute(key, value, null);
   }

   public static String getAttribute(FacesContext context,
            Map<String, Object> attributes, String key) throws IOException
   {
      String value = (String) attributes.get(key);
      if (value != null && !value.isEmpty())
         return value;
      return null;
   }

   public static void addText(FacesContext context,
            Map<String, Object> attributes, String key) throws IOException
   {
      String value = (String) attributes.get(key);
      if (value != null && !value.isEmpty())
         context.getResponseWriter().writeText(value, null);
   }

   public static void addSimpleText(FacesContext context, String text)
            throws IOException
   {
      context.getResponseWriter().writeText(text, null);
   }

   public static void start(FacesContext context, String tag)
            throws IOException
   {
      ResponseWriter responseWriter = context.getResponseWriter();
      responseWriter.startElement(tag, null);
   }

   public static void end(FacesContext context, String tag) throws IOException
   {
      ResponseWriter responseWriter = context.getResponseWriter();
      responseWriter.endElement(tag);
   }

   public static void addFacet(FacesContext context, UIOutput uiOutput,
            String facetName) throws IOException
   {
      UIComponent facet = uiOutput.getFacet(facetName);
      if (facet != null)
      {
         // facet.encodeAll(context);
         ResponseWriter responseWriter = context.getResponseWriter();
         responseWriter.writeText(facet, null);
      }
   }

   public static void addUIOutput(FacesContext context, String resourceURL) throws IOException
   {
      ResponseWriter out = context.getResponseWriter();
      out.startElement("script", null);
      out.writeAttribute("type", "text/javascript", null);
      out.writeAttribute("src", resourceURL, null);
      out.endElement("script");
   }
}
