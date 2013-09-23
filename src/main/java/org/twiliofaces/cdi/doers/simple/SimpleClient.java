/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.doers.simple;

import java.util.logging.Logger;

import com.twilio.sdk.client.TwilioCapability;
import com.twilio.sdk.client.TwilioCapability.DomainException;

public class SimpleClient
{
   Logger logger = Logger.getLogger(getClass().getName());
   private String twilioSid;
   private String twilioToken;
   private String applicationSid;
   private String client;

   public SimpleClient()
   {
   }

   public SimpleClient(String twilioSid, String twilioToken, String applicationSid)
   {
      this.twilioSid = twilioSid;
      this.twilioToken = twilioToken;
      this.applicationSid = applicationSid;
   }

   public String generateToken(String client)
   {
      return client(client).generateToken();
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

   public SimpleClient setTwilioSid(String twilioSid)
   {
      this.twilioSid = twilioSid;
      return this;
   }

   public String getTwilioToken()
   {
      return twilioToken;
   }

   public SimpleClient setTwilioToken(String twilioToken)
   {
      this.twilioToken = twilioToken;
      return this;
   }

   public String getApplicationSid()
   {
      return applicationSid;
   }

   public SimpleClient setApplicationSid(String applicationSid)
   {
      this.applicationSid = applicationSid;
      return this;
   }

   public String getClient()
   {
      return client;
   }

   public SimpleClient setClient(String client)
   {
      this.client = client;
      return this;
   }

   // FAST METHODS

   public SimpleClient twilioToken(String twilioToken)
   {
      setTwilioToken(twilioToken);
      return this;
   }

   public SimpleClient applicationSid(String applicationSid)
   {
      setApplicationSid(applicationSid);
      return this;
   }

   public SimpleClient client(String client)
   {
      setClient(client);
      return this;
   }
}
