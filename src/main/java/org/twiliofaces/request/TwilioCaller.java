/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.request;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

@Named
@RequestScoped
public class TwilioCaller
{

   Logger logger = Logger.getLogger(getClass().getName());

   /**
    * 
    * @param twilioNumber
    * @param to
    * @param sid
    * @param token
    * @param twilioUrl
    */
   public void simpleCall(String twilioNumber, String to, String sid,
            String token, String twilioUrl)
   {
      try
      {
         TwilioRestClient client = new TwilioRestClient(sid, token);
         Account mainAccount = client.getAccount();
         CallFactory callFactory = mainAccount.getCallFactory();
         Map<String, String> callParams = new HashMap<String, String>();
         callParams.put("To", to);
         callParams.put("From", twilioNumber);// twilioNumber
         callParams.put("Url", twilioUrl);
         Call call = callFactory.create(callParams);
         // Print the call SID (a 32 digit hex like CA123..)
         logger.info("call SID: " + call.getSid());
      }
      catch (TwilioRestException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }

   /*
    * insert all params inside Map (like From,To, url)
    */
   public Call call(String sid, String token, Map<String, String> callParams)
            throws TwilioRestException
   {
      TwilioRestClient client = new TwilioRestClient(sid, token);
      Account mainAccount = client.getAccount();
      CallFactory callFactory = mainAccount.getCallFactory();
      return callFactory.create(callParams);
   }
}
