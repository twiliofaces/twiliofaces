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
import org.twiliofaces.annotations.configuration.ApiVersion;
import org.twiliofaces.annotations.notification.AccountSid;
import org.twiliofaces.annotations.notification.CallSid;
import org.twiliofaces.annotations.notification.CallStatus;
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
import org.twiliofaces.annotations.notification.TwilioSignature;
import org.twiliofaces.annotations.sip.DialSipCallId;
import org.twiliofaces.annotations.sip.DialSipHeader;
import org.twiliofaces.annotations.sip.DialSipHeader_;
import org.twiliofaces.annotations.sip.DialSipResponseCode;
import org.twiliofaces.annotations.sip.SipCallId;
import org.twiliofaces.annotations.sip.SipHeader;
import org.twiliofaces.api.enums.TwilioRequestParamsEnum;
import org.twiliofaces.request.TwilioRequestMap;

public class TwilioRequestParamProducer implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Inject
   FacesContext facesContext;

   @Produces
   @TwilioRequestParams
   public TwilioRequestMap getTwilioRequestParams()
   {
      if (facesContext != null && facesContext.getExternalContext() != null)
      {
         TwilioRequestMap twilioRequestParamsMap = new TwilioRequestMap();
         for (TwilioRequestParamsEnum twilio : TwilioRequestParamsEnum.values())
         {
            String value = facesContext.getExternalContext()
                     .getRequestParameterMap().get(twilio.name());
            twilioRequestParamsMap.setValue(twilio.toProperty(), value);
         }
         return twilioRequestParamsMap;
      }
      return null;
   }

   @Produces
   @AccountSid
   public String getAccountSid()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.AccountSid.name());
      }
      return null;
   }

   @Produces
   @ApiVersion
   public String getApiVersion()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.ApiVersion.name());
      }
      return null;
   }

   @Produces
   @CallerName
   public String getCallerName()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.CallerName.name());
      }
      return null;
   }

   @Produces
   @CallSid
   public String getCallSid()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.CallSid.name());
      }
      return null;
   }

   @Produces
   @CallStatus
   public String getCallStatus()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.CallStatus.name());
      }
      return null;
   }

   @Produces
   @DialSipCallId
   public String getDialSipCallId()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.DialSipCallId.name());
      }
      return null;
   }

   @Produces
   @DialSipHeader
   public String getDialSipHeader()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.DialSipHeader.name());
      }
      return null;
   }

   @Produces
   @DialSipHeader_
   public String getDialSipHeader_()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.DialSipHeader_.name());
      }
      return null;
   }

   @Produces
   @DialSipResponseCode
   public String getDialSipResponseCode()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.DialSipResponseCode.name());
      }
      return null;
   }

   @Produces
   @Digits
   public String getDigits()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.Digits.name());
      }
      return null;
   }

   @Produces
   @Direction
   public String getDirection()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.Direction.name());
      }
      return null;
   }

   @Produces
   @ForwardedFrom
   public String getForwardedFrom()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.ForwardedFrom.name());
      }
      return null;
   }

   @Produces
   @From
   public String getFrom()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.From.name());
      }
      return null;
   }

   @Produces
   @FromCity
   public String getFromCity()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.FromCity.name());
      }
      return null;
   }

   @Produces
   @FromCountry
   public String getFromCountry()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.FromCountry.name());
      }
      return null;
   }

   @Produces
   @FromState
   public String getFromState()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.FromState.name());
      }
      return null;
   }

   @Produces
   @RecordingDuration
   public String getRecordingDuration()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.RecordingDuration.name());
      }
      return null;
   }

   @Produces
   @RecordingSid
   public String getRecordingSid()
   {

      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.RecordingSid.name());
      }
      return null;
   }

   @Produces
   @RecordingUrl
   public String getRecordingUrl()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.RecordingUrl.name());
      }
      return null;
   }

   @Produces
   @SipCallId
   public String getSipCallId()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.SipCallId.name());
      }
      return null;
   }

   @Produces
   @SipHeader
   public String getSipHeader()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.SipHeader.name());
      }
      return null;
   }

   @Produces
   @SmsStatus
   public String getSmsStatus()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.SmsStatus.name());
      }
      return null;
   }

   @Produces
   @To
   public String getTo()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.To.name());
      }
      return null;
   }

   @Produces
   @ToCity
   public String getToCity()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.ToCity.name());
      }
      return null;
   }

   @Produces
   @ToCountry
   public String getToCountry()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.ToCountry.name());
      }
      return null;
   }

   @Produces
   @ToState
   public String getToState()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.ToState.name());
      }
      return null;
   }

   @Produces
   @ToZip
   public String getToZip()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.ToZip.name());
      }
      return null;
   }

   @Produces
   @TranscriptionSid
   public String getTranscriptionSid()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.TranscriptionSid.name());
      }
      return null;
   }

   @Produces
   @TranscriptionStatus
   public String getTranscriptionStatus()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.TranscriptionStatus.name());
      }
      return null;
   }

   @Produces
   @TranscriptionText
   public String getTranscriptionText()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.TranscriptionText.name());
      }
      return null;
   }

   @Produces
   @TranscriptionUrl
   public String getTranscriptionUrl()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.TranscriptionUrl.name());
      }
      return null;
   }

   @Produces
   @TwilioSignature
   public String getTwilioSignature()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestHeaderMap()
                  .get("X-Twilio-Signature");
      }
      return null;
   }
}