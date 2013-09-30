/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.extension;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.twiliofaces.cdi.event.StatusCallbackEvent;
import org.twiliofaces.cdi.extension.util.Account;

@ApplicationScoped
public class TwilioManager implements Serializable
{

   private static final long serialVersionUID = 1L;

   private TwilioScopedMap twilioScopedMap;
   private Map<String, Account> twilioAccounts;

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
      return getDefaultAccount().getApplicationSid();
   }

   public void setApplicationSid(String applicationSid)
   {
      getDefaultAccount().setApplicationSid(applicationSid);
   }

   public String getTwilioNumber()
   {
      return getDefaultAccount().getTwilioNumber();
   }

   public void setTwilioNumber(String twilioNumber)
   {
      getDefaultAccount().setTwilioNumber(twilioNumber);
   }

   public String getTwilioSid()
   {
      return getDefaultAccount().getTwilioSid();
   }

   public void setTwilioSid(String twilioSid)
   {
      getDefaultAccount().setTwilioSid(twilioSid);
   }

   public String getTwilioToken()
   {
      return getDefaultAccount().getTwilioToken();
   }

   public void setTwilioToken(String twilioToken)
   {
      getDefaultAccount().setTwilioToken(twilioToken);
   }

   public void setTwilioScopedMap(TwilioScopedMap twilioScopedMap)
   {
      this.twilioScopedMap = twilioScopedMap;
   }

   public Map<String, Account> getTwilioAccounts()
   {
      if (twilioAccounts == null)
         this.twilioAccounts = new HashMap<String, Account>();
      return twilioAccounts;
   }

   public Account getDefaultAccount()
   {
      return getTwilioAccounts().get("default");
   }

   public Account getAccount(String account)
   {
      return getTwilioAccounts().get(account);
   }

   public void setTwilioAccounts(Map<String, Account> twilioAccounts)
   {
      this.twilioAccounts = twilioAccounts;
   }
}