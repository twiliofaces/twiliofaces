/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.web.filter;

import java.io.IOException;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.twiliofaces.api.event.TwimlEvent;

@WebFilter(filterName = "TwimlFilter", urlPatterns = "*.twiml")
public class TwimlFilter implements Filter
{

   @Inject
   Event<TwimlEvent> twimlEventProducer;

   public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
   {

      TwimlWrapper twimlWrapper = new TwimlWrapper(
               (HttpServletResponse) response);
      chain.doFilter(request, twimlWrapper);

      response.getWriter().write(twimlWrapper.getTwiml());
      twimlEventProducer.fire(new TwimlEvent(twimlWrapper.getTwiml()));
   }

   @Override
   public void destroy()
   {

   }

   @Override
   public void init(FilterConfig arg0) throws ServletException
   {

   }

}
