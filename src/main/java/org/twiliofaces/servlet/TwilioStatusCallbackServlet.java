package org.twiliofaces.servlet;

import java.io.IOException;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.twiliofaces.annotations.configuration.ApiVersion;
import org.twiliofaces.annotations.notification.AccountSid;
import org.twiliofaces.annotations.notification.CallSid;
import org.twiliofaces.annotations.notification.CallStatus;
import org.twiliofaces.annotations.notification.CallerName;
import org.twiliofaces.annotations.notification.Direction;
import org.twiliofaces.annotations.notification.ForwardedFrom;
import org.twiliofaces.annotations.notification.From;
import org.twiliofaces.annotations.notification.To;
import org.twiliofaces.event.StatusCallbackEvent;
import org.twiliofaces.event.TwimlEvent;

@WebServlet(value = "/hello", name = "hello-servlet")
public class TwilioStatusCallbackServlet extends HttpServlet {

	@Inject
	@CallSid
	private String callSid;
	@Inject
	@AccountSid
	private String accountSid;
	@Inject
	@From
	private String from;
	@Inject
	@To
	private String to;
	@Inject
	@CallStatus
	private String callStatus;
	@Inject
	@ApiVersion
	private String apiVersion;
	@Inject
	@Direction
	private String direction;
	@Inject
	@ForwardedFrom
	private String forwardedFrom;
	@Inject
	@CallerName
	private String callerName;

	@Inject
	Event<StatusCallbackEvent> statusCallbackEventProducer;

	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		createEvent();
	}

	@Override
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		createEvent();
	}

	private void createEvent() {
		StatusCallbackEvent statusCallbackEvent = new StatusCallbackEvent(
				callSid, accountSid, from, to, callStatus, apiVersion,
				direction, forwardedFrom, callerName);
		System.out.println(statusCallbackEvent.toString());
		statusCallbackEventProducer.fire(statusCallbackEvent);
	}
}
