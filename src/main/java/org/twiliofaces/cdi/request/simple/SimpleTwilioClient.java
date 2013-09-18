/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.request.simple;

import java.util.logging.Logger;

import com.twilio.sdk.client.TwilioCapability;
import com.twilio.sdk.client.TwilioCapability.DomainException;

public class SimpleTwilioClient
{
   Logger logger = Logger.getLogger(getClass().getName());
   private String twilioSid;
   private String twilioToken;
   private String applicationSid;
   private String client;

   public SimpleTwilioClient()
   {
   }

   public SimpleTwilioClient(String twilioSid, String twilioToken, String applicationSid)
   {
      this.twilioSid = twilioSid;
      this.twilioToken = twilioToken;
      this.applicationSid = applicationSid;
   }

   public String generateToken(String client)
   {
      return setClient(client).generateToken();
   }

   public String generateToken()
   {
      TwilioCapability capability = new TwilioCapability(twilioSid,
               twilioToken);
      if (applicationSid != null && !applicationSid.isEmpty())
         capability.allowClientOutgoing(applicationSid);

      if (client == null)
         return null;
      capability.allowClientIncoming(client);
      try
      {
         return capability.generateToken();
      }
      catch (DomainException e)
      {
         logger.severe(e.getMessage());
      }
      return null;
   }

   public String getTwilioSid()
   {
      return twilioSid;
   }

   public SimpleTwilioClient setTwilioSid(String twilioSid)
   {
      this.twilioSid = twilioSid;
      return this;
   }

   public String getTwilioToken()
   {
      return twilioToken;
   }

   public SimpleTwilioClient setTwilioToken(String twilioToken)
   {
      this.twilioToken = twilioToken;
      return this;
   }

   public String getApplicationSid()
   {
      return applicationSid;
   }

   public SimpleTwilioClient setApplicationSid(String applicationSid)
   {
      this.applicationSid = applicationSid;
      return this;
   }

   public String getClient()
   {
      return client;
   }

   public SimpleTwilioClient setClient(String client)
   {
      this.client = client;
      return this;
   }
}
