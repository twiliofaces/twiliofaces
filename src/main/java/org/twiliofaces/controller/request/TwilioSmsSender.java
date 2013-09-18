/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.controller.request;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.cdi.request.simple.SimpleTwilioSmsSender;
import org.twiliofaces.inject.configuration.TwilioAccountSid;
import org.twiliofaces.inject.configuration.TwilioAuthToken;
import org.twiliofaces.inject.configuration.TwilioNumber;

@Named
@RequestScoped
public class TwilioSmsSender extends SimpleTwilioSmsSender
{

   @Inject
   public TwilioSmsSender(@TwilioNumber String from,
            @TwilioAccountSid String accountSid, @TwilioAuthToken String authToken)
   {
      super(from, accountSid, authToken);
   }

   public TwilioSmsSender()
   {
   }

}
