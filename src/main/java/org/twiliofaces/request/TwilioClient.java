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

import org.twiliofaces.annotations.configuration.ApplicationSid;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;
import org.twiliofaces.request.simple.SimpleTwilioClient;

@Named
@RequestScoped
public class TwilioClient extends SimpleTwilioClient
{
   @Inject
   public TwilioClient(@TwilioSid String twilioSid,
            @TwilioToken String twilioToken,
            @ApplicationSid String applicationSid)
   {
      super.setTwilioSid(twilioSid);
      super.setTwilioToken(twilioToken);
      super.setApplicationSid(applicationSid);
   }

   public TwilioClient()
   {
   }
}
