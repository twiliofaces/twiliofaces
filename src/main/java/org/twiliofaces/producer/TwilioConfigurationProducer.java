/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.producer;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.annotations.configuration.ApplicationSid;
import org.twiliofaces.annotations.configuration.TwilioNumber;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;
import org.twiliofaces.api.enums.TwilioConfigurationEnum;

public class TwilioConfigurationProducer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	FacesContext facesContext;

	@Produces
	@TwilioNumber
	public String getTwilioNumber() {
		return facesContext.getExternalContext().getInitParameter(
				TwilioConfigurationEnum.TWILIO_NUMBER.name());
	}

	@Produces
	@TwilioSid
	public String getTwilioSid() {
		return facesContext.getExternalContext().getInitParameter(
				TwilioConfigurationEnum.TWILIO_SID.name());
	}

	@Produces
	@TwilioToken
	public String getTwilioToken() {
		return facesContext.getExternalContext().getInitParameter(
				TwilioConfigurationEnum.TWILIO_TOKEN.name());
	}

	@Produces
	@ApplicationSid
	public String getApplicationSid() {
		return facesContext.getExternalContext().getInitParameter(
				TwilioConfigurationEnum.APPLICATION_SID.name());
	}
}
