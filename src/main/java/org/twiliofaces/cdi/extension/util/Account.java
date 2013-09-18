/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.extension.util;

import java.io.Serializable;
import java.lang.reflect.Field;

public class Account
         implements Serializable
{
   private static final long serialVersionUID = 1L;
   private String name;
   private String applicationSid;
   private String twilioNumber;
   private String twilioSid;
   private String twilioToken;

   public Account()
   {
   }

   public Account(String name)
   {
      this.name = name;
   }

   public String getApplicationSid()
   {
      return applicationSid;
   }

   public Account setApplicationSid(String applicationSid)
   {
      this.applicationSid = applicationSid;
      return this;
   }

   public String getTwilioNumber()
   {
      return twilioNumber;
   }

   public Account setTwilioNumber(String twilioNumber)
   {
      this.twilioNumber = twilioNumber;
      return this;
   }

   public String getTwilioSid()
   {
      return twilioSid;
   }

   public Account setTwilioSid(String twilioSid)
   {
      this.twilioSid = twilioSid;
      return this;
   }

   public String getTwilioToken()
   {
      return twilioToken;
   }

   public Account setTwilioToken(String twilioToken)
   {
      this.twilioToken = twilioToken;
      return this;
   }

   public String getName()
   {
      return name;
   }

   public Account setName(String name)
   {
      this.name = name;
      return this;
   }

   public void setField(String name, Object value) throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException
   {
      Field field = getClass().getDeclaredField(name);
      field.set(this, value);
   }

   public void isValid() throws Exception
   {
      if (getName() == null || getName().isEmpty())
         throw new Exception("Account Name is null or empty");

      // if (getApplicationSid() == null || getApplicationSid().isEmpty())
      // throw new Exception("Application Sid [" + getName() + "] is null or empty");

      if (getTwilioNumber() == null || getTwilioNumber().isEmpty())
         throw new Exception("Twilio Number [" + getName() + "] is null or empty");

      if (getTwilioSid() == null || getTwilioSid().isEmpty())
         throw new Exception("Twilio Sid [" + getName() + "] is null or empty");

      if (getTwilioToken() == null || getTwilioToken().isEmpty())
         throw new Exception("Twilio Token [" + getName() + "] is null or empty");
   }

   @Override
   public String toString()
   {
      return "Account [name=" + name + ", applicationSid=" + applicationSid + ", twilioNumber=" + twilioNumber
               + ", twilioSid=" + twilioSid + ", twilioToken=" + twilioToken + "]";
   }

}
