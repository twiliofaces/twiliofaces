/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.request;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.configuration.TwilioNumber;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;

@Named
@RequestScoped
public abstract class TwilioCaller extends AbstractTwilioCaller {

	Logger logger = Logger.getLogger(getClass().getName());

	private String to;
	private String endpoint;

	@Inject
	@TwilioNumber
	private String from;
	@Inject
	@TwilioSid
	private String accountSid;
	@Inject
	@TwilioToken
	private String authToken;

	public String getFrom() {
		return from;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getTo() {
		return to;
	}

	public TwilioCaller setTo(String to) {
		this.to = to;
		return this;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public TwilioCaller setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

	@Override
	public AbstractTwilioCaller setFrom(String from) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractTwilioCaller setAccountSid(String accountSid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractTwilioCaller setAuthToken(String authToken) {
		// TODO Auto-generated method stub
		return null;
	}
}
