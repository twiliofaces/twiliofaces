/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.doers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.cdi.doers.simple.SimpleClient;
import org.twiliofaces.inject.configuration.TwilioAccountSid;
import org.twiliofaces.inject.configuration.TwilioAuthToken;
import org.twiliofaces.inject.configuration.TwilioConnectAppSid;

@Named
@RequestScoped
public class Client extends SimpleClient
{
   @Inject
   public Client(@TwilioAccountSid String twilioSid,
            @TwilioAuthToken String twilioToken,
            @TwilioConnectAppSid String applicationSid)
   {
      super(twilioSid, twilioToken, applicationSid);
   }

   public Client()
   {
   }
}
