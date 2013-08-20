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
import org.twiliofaces.request.simple.SimpleTwilioCaller;

@Named
@RequestScoped
public class TwilioCaller extends SimpleTwilioCaller
{

   @Inject
   public TwilioCaller(@TwilioNumber String from,
            @TwilioSid String accountSid, @TwilioToken String authToken)
   {
      super(from, accountSid, authToken);
   }

   public TwilioCaller()
   {
   }
}