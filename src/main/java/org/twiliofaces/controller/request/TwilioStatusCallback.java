/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.controller.request;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.api.event.StatusCallbackEvent;
import org.twiliofaces.inject.notification.AccountSid;
import org.twiliofaces.inject.notification.ApiVersion;
import org.twiliofaces.inject.notification.CallSid;
import org.twiliofaces.inject.notification.CallStatus;
import org.twiliofaces.inject.notification.CallerName;
import org.twiliofaces.inject.notification.Direction;
import org.twiliofaces.inject.notification.ForwardedFrom;
import org.twiliofaces.inject.notification.From;
import org.twiliofaces.inject.notification.To;

@RequestScoped
@Named
public class TwilioStatusCallback implements Serializable
{

   Logger logger = Logger.getLogger(getClass().getName());

   private static final long serialVersionUID = 1L;

   @Inject
   @CallSid
   private String callSid;
   @Inject
   @AccountSid
   private String accountSid;
   @Inject
   @From
   private String from;
   @Inject
   @To
   private String to;
   @Inject
   @CallStatus
   private String callStatus;
   @Inject
   @ApiVersion
   private String apiVersion;
   @Inject
   @Direction
   private String direction;
   @Inject
   @ForwardedFrom
   private String forwardedFrom;
   @Inject
   @CallerName
   private String callerName;

   @Inject
   Event<StatusCallbackEvent> statusCallbackEventProducer;

   public void evaluate()
   {
      StatusCallbackEvent statusCallbackEvent = new StatusCallbackEvent(
               callSid, accountSid, from, to, callStatus, apiVersion,
               direction, forwardedFrom, callerName);
      logger.info(statusCallbackEvent.toString());
      statusCallbackEventProducer.fire(statusCallbackEvent);
   }

}
