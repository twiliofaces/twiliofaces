/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.producer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.cdi.producer.util.TwilioRequestMap;
import org.twiliofaces.cdi.producer.util.TwilioRequestParamsEnum;
import org.twiliofaces.inject.notification.AccountSid;
import org.twiliofaces.inject.notification.ApiVersion;
import org.twiliofaces.inject.notification.Body;
import org.twiliofaces.inject.notification.CallSid;
import org.twiliofaces.inject.notification.CallStatus;
import org.twiliofaces.inject.notification.Caller;
import org.twiliofaces.inject.notification.CallerName;
import org.twiliofaces.inject.notification.Digits;
import org.twiliofaces.inject.notification.Direction;
import org.twiliofaces.inject.notification.ForwardedFrom;
import org.twiliofaces.inject.notification.From;
import org.twiliofaces.inject.notification.FromCity;
import org.twiliofaces.inject.notification.FromCountry;
import org.twiliofaces.inject.notification.FromState;
import org.twiliofaces.inject.notification.FromZip;
import org.twiliofaces.inject.notification.MediaContentTypes;
import org.twiliofaces.inject.notification.MediaUrls;
import org.twiliofaces.inject.notification.MessageSid;
import org.twiliofaces.inject.notification.NumMedia;
import org.twiliofaces.inject.notification.PhoneNumber;
import org.twiliofaces.inject.notification.RecordingDuration;
import org.twiliofaces.inject.notification.RecordingSid;
import org.twiliofaces.inject.notification.RecordingUrl;
import org.twiliofaces.inject.notification.SmsSid;
import org.twiliofaces.inject.notification.SmsStatus;
import org.twiliofaces.inject.notification.To;
import org.twiliofaces.inject.notification.ToCity;
import org.twiliofaces.inject.notification.ToCountry;
import org.twiliofaces.inject.notification.ToState;
import org.twiliofaces.inject.notification.ToZip;
import org.twiliofaces.inject.notification.TranscriptionSid;
import org.twiliofaces.inject.notification.TranscriptionStatus;
import org.twiliofaces.inject.notification.TranscriptionText;
import org.twiliofaces.inject.notification.TranscriptionUrl;
import org.twiliofaces.inject.notification.TwilioRequestParams;
import org.twiliofaces.inject.notification.TwilioSignature;
import org.twiliofaces.inject.notification.sip.DialSipCallId;
import org.twiliofaces.inject.notification.sip.DialSipHeader;
import org.twiliofaces.inject.notification.sip.DialSipHeader_;
import org.twiliofaces.inject.notification.sip.DialSipResponseCode;
import org.twiliofaces.inject.notification.sip.SipCallId;
import org.twiliofaces.inject.notification.sip.SipHeader;

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
   @Body
   public String getBody()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.Body.name());
      }
      return null;
   }

   @Produces
   @Caller
   public String getCaller()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.Caller.name());
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
   @FromZip
   public String getFromZip()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.FromZip.name());
      }
      return null;
   }

   @Produces
   @MediaContentTypes
   public List<String> getMediaContentTypes()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         List<String> mediaContentTypes = new ArrayList<String>();
         String numMedia = getNumMedia();
         if (numMedia != null && Integer.parseInt(numMedia) > 0)
         {
            for (int i = 0; i <= Integer.parseInt(numMedia); i++)
            {
               String value = facesContext.getExternalContext().getRequestParameterMap()
                        .get(TwilioRequestParamsEnum.MediaContentType + "" + i);
               if (value != null && !value.isEmpty())
                  mediaContentTypes.add(value);
            }
            return mediaContentTypes;
         }
      }
      return null;
   }

   @Produces
   @MediaUrls
   public List<String> getMediaUrls()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         List<String> mediaUrls = new ArrayList<String>();
         String numMedia = getNumMedia();
         if (numMedia != null && Integer.parseInt(numMedia) > 0)
         {
            for (int i = 0; i <= Integer.parseInt(numMedia); i++)
            {
               String value = facesContext.getExternalContext().getRequestParameterMap()
                        .get(TwilioRequestParamsEnum.MediaUrl + "" + i);
               if (value != null && !value.isEmpty())
                  mediaUrls.add(value);
            }
            return mediaUrls;
         }
      }
      return null;
   }

   @Produces
   @MessageSid
   public String getMessageSid()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.MessageSid.name());
      }
      return null;
   }

   @Produces
   @NumMedia
   public String getNumMedia()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.NumMedia.name());
      }
      return null;
   }

   @Produces
   @PhoneNumber
   public String getPhoneNumber()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.PhoneNumber.name());
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
   @SmsSid
   public String getSmsSid()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.SmsSid.name());
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