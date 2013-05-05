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

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

@Named
@RequestScoped
public class TwilioCaller {

	Logger logger = Logger.getLogger(getClass().getName());

	private String from;
	private String to;
	private String accountSid;
	private String authToken;
	private String endpoint;

	private Map<String, String> callParams;

	public String simpleCall(String from, String to, String accountSid,
			String authToken, String endpoint) {
		setFrom(from).setTo(to).setAuthToken(authToken)
				.setAccountSid(accountSid);
		return call();
	}

	public String call() {
		try {
			TwilioRestClient client = new TwilioRestClient(getAccountSid(),
					getAuthToken());
			Account mainAccount = client.getAccount();
			CallFactory callFactory = mainAccount.getCallFactory();
			getCallParams().put("To", getTo());
			getCallParams().put("From", getFrom());// twilioNumber
			getCallParams().put("Url", getEndpoint());
			Call call = callFactory.create(callParams);
			return call.getSid();
		} catch (TwilioRestException e) {
			e.printStackTrace();
		}
		return null;

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

	public TwilioCaller setCallParams(Map<String, String> callParams) {
		this.callParams = callParams;
		return this;
	}

	public String getFrom() {
		return from;
	}

	public TwilioCaller setFrom(String from) {
		this.from = from;
		return this;
	}

	public String getTo() {
		return to;
	}

	public TwilioCaller setTo(String to) {
		this.to = to;
		return this;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public TwilioCaller setAccountSid(String accountSid) {
		this.accountSid = accountSid;
		return this;
	}

	public String getAuthToken() {
		return authToken;
	}

	public TwilioCaller setAuthToken(String authToken) {
		this.authToken = authToken;
		return this;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public TwilioCaller setEndpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}
}
