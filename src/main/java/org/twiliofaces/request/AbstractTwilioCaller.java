/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.request;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

public abstract class AbstractTwilioCaller {

	protected Map<String, String> callParams;

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

	public AbstractTwilioCaller setCallParams(Map<String, String> callParams) {
		this.callParams = callParams;
		return this;
	}

	public abstract String getFrom();

	public abstract AbstractTwilioCaller setFrom(String from);

	public abstract String getTo();

	public abstract AbstractTwilioCaller setTo(String to);

	public abstract String getAccountSid();

	public abstract AbstractTwilioCaller setAccountSid(String accountSid);

	public abstract String getAuthToken();

	public abstract AbstractTwilioCaller setAuthToken(String authToken);

	public abstract String getEndpoint();

	public abstract AbstractTwilioCaller setEndpoint(String endpoint);
}
