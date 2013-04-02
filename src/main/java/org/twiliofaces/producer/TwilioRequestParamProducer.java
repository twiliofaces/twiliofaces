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

import org.twiliofaces.annotations.configuration.ApiVersion;
import org.twiliofaces.annotations.notification.AccountSid;
import org.twiliofaces.annotations.notification.CallSid;
import org.twiliofaces.annotations.notification.CallerName;
import org.twiliofaces.annotations.notification.Digits;
import org.twiliofaces.annotations.notification.Direction;
import org.twiliofaces.annotations.notification.ForwardedFrom;
import org.twiliofaces.annotations.notification.From;
import org.twiliofaces.annotations.notification.FromCity;
import org.twiliofaces.annotations.notification.FromCountry;
import org.twiliofaces.annotations.notification.FromState;
import org.twiliofaces.annotations.notification.RecordingDuration;
import org.twiliofaces.annotations.notification.RecordingSid;
import org.twiliofaces.annotations.notification.RecordingUrl;
import org.twiliofaces.annotations.notification.SmsStatus;
import org.twiliofaces.annotations.notification.To;
import org.twiliofaces.annotations.notification.ToCity;
import org.twiliofaces.annotations.notification.ToCountry;
import org.twiliofaces.annotations.notification.ToState;
import org.twiliofaces.annotations.notification.ToZip;
import org.twiliofaces.annotations.notification.TranscriptionSid;
import org.twiliofaces.annotations.notification.TranscriptionStatus;
import org.twiliofaces.annotations.notification.TranscriptionText;
import org.twiliofaces.annotations.notification.TranscriptionUrl;
import org.twiliofaces.annotations.sip.DialSipCallId;
import org.twiliofaces.annotations.sip.DialSipHeader;
import org.twiliofaces.annotations.sip.DialSipHeader_;
import org.twiliofaces.annotations.sip.DialSipResponseCode;
import org.twiliofaces.annotations.sip.SipCallId;
import org.twiliofaces.annotations.sip.SipHeader;
import org.twiliofaces.enums.TwilioRequestParamsEnum;

public class TwilioRequestParamProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FacesContext facesContext;

	@Produces
	@AccountSid
	public String getAccountSid() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.AccountSid.name());
	}

	@Produces
	@ApiVersion
	public String getApiVersion() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ApiVersion.name());
	}

	@Produces
	@CallerName
	public String getCallerName() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.CallerName.name());
	}

	@Produces
	@CallSid
	public String getCallSid() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.CallSid.name());
	}

	@Produces
	@To
	public String getCallStatus() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.CallStatus.name());
	}

	@Produces
	@DialSipCallId
	public String getDialSipCallId() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.DialSipCallId.name());
	}

	@Produces
	@DialSipHeader
	public String getDialSipHeader() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.DialSipHeader.name());
	}

	@Produces
	@DialSipHeader_
	public String getDialSipHeader_() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.DialSipHeader_.name());
	}

	@Produces
	@DialSipResponseCode
	public String getDialSipResponseCode() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.DialSipResponseCode.name());
	}

	@Produces
	@Digits
	public String getDigits() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.Digits.name());
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
	@From
	public String getFrom() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.From.name());
	}

	@Produces
	@FromCity
	public String getFromCity() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.FromCity.name());
	}

	@Produces
	@FromCountry
	public String getFromCountry() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.FromCountry.name());
	}

	@Produces
	@FromState
	public String getFromState() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.FromState.name());
	}

	@Produces
	@RecordingDuration
	public String getRecordingDuration() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.RecordingDuration.name());
	}

	@Produces
	@RecordingSid
	public String getRecordingSid() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.RecordingSid.name());
	}

	@Produces
	@RecordingUrl
	public String getRecordingUrl() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.RecordingUrl.name());
	}

	@Produces
	@SipCallId
	public String getSipCallId() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.SipCallId.name());
	}

	@Produces
	@SipHeader
	public String getSipHeader() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.SipHeader.name());
	}

	@Produces
	@SmsStatus
	public String getSmsStatus() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.SmsStatus.name());
	}

	@Produces
	@To
	public String getTo() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.To.name());
	}

	@Produces
	@ToCity
	public String getToCity() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ToCity.name());
	}

	@Produces
	@ToCountry
	public String getToCountry() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.ToCountry.name());
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
	@TranscriptionSid
	public String getTranscriptionSid() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.TranscriptionSid.name());
	}

	@Produces
	@TranscriptionStatus
	public String getTranscriptionStatus() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.TranscriptionStatus.name());
	}

	@Produces
	@TranscriptionText
	public String getTranscriptionText() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.TranscriptionText.name());
	}

	@Produces
	@TranscriptionUrl
	public String getTranscriptionUrl() {
		return facesContext.getExternalContext().getRequestParameterMap()
				.get(TwilioRequestParamsEnum.TranscriptionUrl.name());
	}

}
