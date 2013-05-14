/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.request;

import java.util.logging.Logger;

public class SimpleTwilioCaller extends AbstractTwilioCaller {

	Logger logger = Logger.getLogger(getClass().getName());

	private String to;
	private String endpoint;
	private String from;
	private String accountSid;
	private String authToken;

	public String getFrom() {
		return from;
	}

	public SimpleTwilioCaller setFrom(String from) {
		this.from = from;
		return this;
	}

	public String getTo() {
		return to;
	}

	public SimpleTwilioCaller setTo(String to) {
		this.to = to;
		return this;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public SimpleTwilioCaller setAccountSid(String accountSid) {
		this.accountSid = accountSid;
		return this;
	}

	public String getAuthToken() {
		return authToken;
	}

	public SimpleTwilioCaller setAuthToken(String authToken) {
		this.authToken = authToken;
		return this;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public SimpleTwilioCaller setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}
}
