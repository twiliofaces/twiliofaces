/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.extension;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.twiliofaces.api.event.StatusCallbackEvent;

@ApplicationScoped
public class TwilioManager implements Serializable
{

   private static final long serialVersionUID = 1L;
   
   private TwilioScopedMap twilioScopedMap;

   private String applicationSid;
   private String twilioNumber;
   private String twilioSid;
   private String twilioToken;

   public TwilioManager()
   {
   }

   public void processEvent(@Observes StatusCallbackEvent event)
   {
      if (event instanceof StatusCallbackEvent)
      {
         getTwilioScopedMap().remove(event.getCallSid());
      }
   }

   @SuppressWarnings("unchecked")
   public <T> T getVariable(String variableName)
   {
      Object value = null;
      if (getTwilioScopedMap().holdsValue(variableName))
      {
         value = getTwilioScopedMap().getContextualInstance(variableName);
         return (T) value;
      }
      return null;
   }

   @SuppressWarnings("unchecked")
   public <T> T getOrCreate(String callSid, Object instance)
   {
      Object value = null;
      if (getTwilioScopedMap().holdsValue(callSid))
      {
         value = getTwilioScopedMap().getContextualInstance(callSid);
         return (T) value;
      }
      else
      {
         getTwilioScopedMap().put(callSid, instance);
         return (T) instance;
      }
   }

   public void setVariable(String variableName, Object value)
   {
      getTwilioScopedMap().put(variableName, value);
   }

   public TwilioScopedMap getTwilioScopedMap()
   {
      if (twilioScopedMap == null)
         this.twilioScopedMap = new TwilioScopedMap();
      return twilioScopedMap;
   }

   public void setBeanStore(TwilioScopedMap beanStore)
   {
      this.twilioScopedMap = beanStore;
   }

   public String getApplicationSid()
   {
      return applicationSid;
   }

   public void setApplicationSid(String applicationSid)
   {
      this.applicationSid = applicationSid;
   }

   public String getTwilioNumber()
   {
      return twilioNumber;
   }

   public void setTwilioNumber(String twilioNumber)
   {
      this.twilioNumber = twilioNumber;
   }

   public String getTwilioSid()
   {
      return twilioSid;
   }

   public void setTwilioSid(String twilioSid)
   {
      this.twilioSid = twilioSid;
   }

   public String getTwilioToken()
   {
      return twilioToken;
   }

   public void setTwilioToken(String twilioToken)
   {
      this.twilioToken = twilioToken;
   }

   public void setTwilioScopedMap(TwilioScopedMap twilioScopedMap)
   {
      this.twilioScopedMap = twilioScopedMap;
   }
}