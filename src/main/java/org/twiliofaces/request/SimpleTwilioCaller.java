/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.request;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

public class SimpleTwilioCaller {

	Logger logger = Logger.getLogger(getClass().getName());

	private String from;
	private String accountSid;
	private String authToken;
	
	private String to;
	private String endpoint;

	private Map<String, String> callParams;

	public SimpleTwilioCaller() {

	}

	public String simpleCall(String from, String to, String accountSid,
			String authToken, String endpoint) throws TwilioRestException {
		setFrom(from).setTo(to).setAuthToken(authToken)
				.setAccountSid(accountSid);
		return call();
	}

	public String call() throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(getAccountSid(),
				getAuthToken());
		Account mainAccount = client.getAccount();
		CallFactory callFactory = mainAccount.getCallFactory();
		getCallParams().put("To", getTo());
		getCallParams().put("From", getFrom());// twilioNumber
		getCallParams().put("Url", getEndpoint());
		Call call = callFactory.create(callParams);
		return call.getSid();
	}

	public Call call(String accountSid, String authToken,
			Map<String, String> callParams) throws TwilioRestException {
		setAuthToken(authToken).setAccountSid(accountSid).setCallParams(
				callParams);
		TwilioRestClient client = new TwilioRestClient(getAccountSid(),
				getAuthToken());
		Account mainAccount = client.getAccount();
		CallFactory callFactory = mainAccount.getCallFactory();
		return callFactory.create(getCallParams());
	}

	public Map<String, String> getCallParams() {
		if (callParams == null)
			this.callParams = new HashMap<String, String>();
		return callParams;
	}

	public SimpleTwilioCaller setCallParams(Map<String, String> callParams) {
		this.callParams = callParams;
		return this;
	}

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