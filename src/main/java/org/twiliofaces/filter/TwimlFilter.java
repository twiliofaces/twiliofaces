package org.twiliofaces.filter;

import java.io.IOException;
import java.io.PrintWriter;

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

import org.twiliofaces.event.TwimlEvent;

@WebFilter(filterName = "TwimlFilter", urlPatterns = "*.jsf")
public class TwimlFilter implements Filter {

	@Inject
	Event<TwimlEvent> twimlEventProducer;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		TwimlWrapper twimlWrapper = new TwimlWrapper(
				(HttpServletResponse) response);
		chain.doFilter(request, twimlWrapper);

		// I just want the output on stdout at the moment...
		response.getWriter().write(twimlWrapper.getTwiml());
		twimlEventProducer.fire(new TwimlEvent(twimlWrapper.getTwiml()));
	}

	public void destroy() {

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
