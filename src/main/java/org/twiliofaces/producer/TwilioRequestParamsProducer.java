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

import org.twiliofaces.annotations.TwilioRequestParams;
import org.twiliofaces.enums.TwilioRequestParamsEnum;
import org.twiliofaces.request.TwilioRequestParamsMap;

public class TwilioRequestParamsProducer implements Serializable {

	private static final long serialVersionUID = -4260202951977249652L;
	@Inject
	FacesContext facesContext;

	@Produces
	@TwilioRequestParams
	public TwilioRequestParamsMap getTwilioRequestParams() {
		TwilioRequestParamsMap twilioRequestParamsMap = new TwilioRequestParamsMap();
		for (TwilioRequestParamsEnum twilio : TwilioRequestParamsEnum.values()) {
			String value = facesContext.getExternalContext()
					.getRequestParameterMap().get(twilio.name());
			twilioRequestParamsMap.setValue(twilio.toProperty(), value);
		}
		return twilioRequestParamsMap;
	}
}
