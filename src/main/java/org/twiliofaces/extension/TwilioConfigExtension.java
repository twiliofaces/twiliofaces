/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.extension;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

import org.twiliofaces.api.configuration.KeyValue;
import org.twiliofaces.api.configuration.TwilioAccount;

/**
 * @author Gavin King
 * @link http://in.relation.to/13053.lace
 */
public class TwilioConfigExtension
         implements Extension
{
   static String TWILIO_PROPERTIS_FILE = "accounts.properties";
   static String TWILIO_ACCOUNT_KEY = "twilio.accounts";
   Logger logger = Logger.getLogger(getClass().getName());

   public void bind(@Observes AfterBeanDiscovery event, BeanManager beanManager)
   {
      {
         logger.info("TwilioConfigExtension starting up");
         InputStream stream = this.getClass().getClassLoader().getResourceAsStream(TWILIO_PROPERTIS_FILE);
         Map<String, TwilioAccount> twilioAccounts = new HashMap<String, TwilioAccount>();
         Properties props = new Properties();
         if (stream != null)
         {
            try
            {
               props.load(stream);
               if (props.containsKey(TWILIO_ACCOUNT_KEY))
               {
                  String value = (String) props.get(TWILIO_ACCOUNT_KEY);
                  String[] names = value.split(",");
                  for (String name : names)
                  {
                     TwilioAccount account = new TwilioAccount(name.trim().toLowerCase());
                     twilioAccounts.put(account.getName(), account);
                  }
               }
               for (Object k : props.keySet())
               {
                  String key = (String) k;
                  if (!key.equals(TWILIO_ACCOUNT_KEY))
                  {
                     KeyValue keyValue = from(key, props.getProperty(key));
                     if (keyValue != null)
                        in(keyValue, twilioAccounts);
                  }
               }
               getTwilioManager(beanManager).setTwilioAccounts(twilioAccounts);
               for (String accKey : twilioAccounts.keySet())
               {
                  logger.info(twilioAccounts.get(accKey).toString());
                  // twilioAccounts.get(accKey).isValid();
               }

            }
            catch (Exception e)
            {
               logger.info(e.getMessage());
            }
            finally
            {
               try
               {
                  stream.close();
               }
               catch (IOException e)
               {
               }
            }
         }
         else
         {
            logger.info("no file acounts.properties in class path");
         }
         logger.info("TwilioConfigExtension terminated");
      }
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   private TwilioManager getTwilioManager(BeanManager beanManager)
   {
      Bean phBean = (Bean) beanManager.getBeans(TwilioManager.class)
               .iterator().next();
      CreationalContext cc = beanManager.createCreationalContext(phBean);
      TwilioManager bean = (TwilioManager) beanManager.getReference(phBean,
               TwilioManager.class, cc);
      return bean;
   }

   private static KeyValue from(String key, String value)
   {
      if (key != null && !key.isEmpty() && key.contains("."))
      {
         String[] s = key.split("\\.");
         KeyValue keyValue = new KeyValue(s[1].trim().toLowerCase(), s[2].trim(), value.trim());
         return keyValue;
      }
      return null;

   }

   private static void in(KeyValue keyValue, Map<String, TwilioAccount> accounts) throws Exception
   {
      if (accounts.containsKey(keyValue.getAccount()))
      {
         TwilioAccount account = accounts.get(keyValue.getAccount());
         account.setField(keyValue.getKey(), keyValue.getValue());
      }
      else
      {
         throw new Exception("account " + keyValue.getAccount() + " doesn't exist on the map");
      }
   }
}
