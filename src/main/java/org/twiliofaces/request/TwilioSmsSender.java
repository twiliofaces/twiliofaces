/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.request;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.configuration.TwilioNumber;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;

@Named
@RequestScoped
public class TwilioSmsSender extends SimpleTwilioSmsSender {

	@Inject
	public TwilioSmsSender(@TwilioNumber String from,
			@TwilioSid String accountSid, @TwilioToken String authToken) {
		super.setFrom(from);
		super.setAuthToken(authToken);
		super.setAccountSid(accountSid);
	}

	public TwilioSmsSender() {
	}

}
