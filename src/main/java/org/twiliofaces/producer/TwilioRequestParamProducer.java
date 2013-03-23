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

import org.twiliofaces.annotations.AccountSid;
import org.twiliofaces.annotations.ApiVersion;
import org.twiliofaces.annotations.CallSid;
import org.twiliofaces.annotations.CallerName;
import org.twiliofaces.annotations.Direction;
import org.twiliofaces.annotations.ForwardedFrom;
import org.twiliofaces.annotations.From;
import org.twiliofaces.annotations.FromCity;
import org.twiliofaces.annotations.FromCountry;
import org.twiliofaces.annotations.FromState;
import org.twiliofaces.annotations.FromZip;
import org.twiliofaces.annotations.To;
import org.twiliofaces.annotations.ToCity;
import org.twiliofaces.annotations.ToCountry;
import org.twiliofaces.annotations.ToState;
import org.twiliofaces.annotations.ToZip;
import org.twiliofaces.enums.TwilioRequestParamsEnum;

public class TwilioRequestParamProducer implements Serializable {

	private static final long serialVersionUID = -4260202951977249652L;
	@Inject
	FacesContext facesContext;

	@Produces
	@AccountSid
	public String getAccountSid() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.AccountSid.name());
	}

	@Produces
	@CallSid
	public String getCallSid() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.CallSid.name());
	}

	@Produces
	@From
	public String getFrom() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.From.name());
	}

	@Produces
	@To
	public String getTo() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.To.name());
	}

	@Produces
	@To
	public String getCallStatus() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.CallStatus.name());
	}

	// ,
	@Produces
	@ApiVersion
	public String getApiVersion() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ApiVersion.name());
	}

	@Produces
	@Direction
	public String getDirection() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.Direction.name());
	}

	@Produces
	@ForwardedFrom
	public String getForwardedFrom() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ForwardedFrom.name());
	}

	@Produces
	@CallerName
	public String getCallerName() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.CallerName.name());
	}

	@Produces
	@FromCity
	public String getFromCity() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.FromCity.name());
	}

	@Produces
	@FromState
	public String getFromState() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.FromState.name());
	}

	@Produces
	@FromZip
	public String getFromZip() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.FromZip.name());
	}

	@Produces
	@FromCountry
	public String getFromCountry() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.FromCountry.name());
	}

	@Produces
	@ToCity
	public String getToCity() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ToCity.name());
	}

	@Produces
	@ToState
	public String getToState() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ToState.name());
	}

	@Produces
	@ToZip
	public String getToZip() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ToZip.name());
	}

	@Produces
	@ToCountry
	public String getToCountry() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ToCountry.name());
	}
}
