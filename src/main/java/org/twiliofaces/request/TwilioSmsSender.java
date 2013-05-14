/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;

@Named
@RequestScoped
public class TwilioSmsSender {

	Logger logger = Logger.getLogger(getClass().getName());

	private String accountSid;
	private String authToken;
	private String from;
	private String to;
	private List<String> recipients;
	private String body;
	private Map<String, String> smsParams;

	public String send() throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(getAccountSid(),
				getAuthToken());
		Account account = client.getAccount();
		SmsFactory smsFactory = account.getSmsFactory();
		getSmsParams().put("To", getTo());
		getSmsParams().put("From", getFrom());
		getSmsParams().put("Body", getBody());
		return smsFactory.create(smsParams).getSid();
	}

	public String simpleSend(String from, String to, String body,
			String accountSid, String authToken) throws TwilioRestException {
		setAccountSid(accountSid).setAuthToken(authToken).setTo(to)
				.setFrom(from).setBody(body);
		return send();
	}

	public Sms send(String accountSid, String authToken,
			Map<String, String> smsParams) throws TwilioRestException {
		setAccountSid(accountSid).setAuthToken(authToken).setSmsParams(
				smsParams);
		TwilioRestClient client = new TwilioRestClient(getAccountSid(),
				getAuthToken());
		Account account = client.getAccount();
		SmsFactory smsFactory = account.getSmsFactory();
		Sms sms = smsFactory.create(getSmsParams());
		return sms;
	}

	public List<Sms> multimpleSend() throws TwilioRestException {
		getSmsParams().put("From", getFrom());
		getSmsParams().put("Body", getBody());
		List<Sms> results = new ArrayList<Sms>();
		for (String recipient : getRecipients()) {
			getSmsParams().put("To", getTo());
			Sms sms = send(recipient, recipient, smsParams);
			results.add(sms);
		}

		return results;
	}

	public Map<String, String> getSmsParams() {
		if (smsParams == null)
			this.smsParams = new HashMap<String, String>();
		return smsParams;
	}

	public TwilioSmsSender setSmsParams(Map<String, String> smsParams) {
		this.smsParams = smsParams;
		return this;
	}

	public TwilioSmsSender addSmsParam(String key, String value) {
		getSmsParams().put(key, value);
		return this;
	}

	public String getFrom() {
		return from;
	}

	public TwilioSmsSender setFrom(String from) {
		this.from = from;
		return this;
	}

	public String getTo() {
		return to;
	}

	public TwilioSmsSender setTo(String to) {
		this.to = to;
		return this;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public TwilioSmsSender setAccountSid(String accountSid) {
		this.accountSid = accountSid;
		return this;
	}

	public String getAuthToken() {
		return authToken;
	}

	public TwilioSmsSender setAuthToken(String authToken) {
		this.authToken = authToken;
		return this;
	}

	public String getBody() {
		return body;
	}

	public TwilioSmsSender setBody(String body) {
		this.body = body;
		return this;
	}

	public List<String> getRecipients() {
		if (recipients == null)
			this.recipients = new ArrayList<String>();
		return recipients;
	}

	public TwilioSmsSender setRecipients(List<String> recipients) {
		this.recipients = recipients;
		return this;
	}

	public TwilioSmsSender addRecipient(String recipient) {
		getRecipients().add(recipient);
		return this;
	}
}
