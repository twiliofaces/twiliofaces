/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.request.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

public class SimpleTwilioCaller
{

   Logger logger = Logger.getLogger(getClass().getName());

   private String from;
   private String accountSid;
   private String authToken;

   private String to;
   private String endpoint;

   private Map<String, String> callParams;

   public SimpleTwilioCaller()
   {
   }

   public SimpleTwilioCaller(String from,
            String accountSid, String authToken)
   {
      this.from = from;
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public String simpleCall(String from, String to, String accountSid,
            String authToken, String endpoint) throws TwilioRestException
   {
      from(from).to(to).authToken(authToken)
               .accountSid(accountSid);
      return call();
   }

   public String call() throws TwilioRestException
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(),
               getAuthToken());
      Account mainAccount = client.getAccount();
      CallFactory callFactory = mainAccount.getCallFactory();

      Call call = callFactory.create(getCallParams());
      return call.getSid();
   }

   public Call call(String accountSid, String authToken,
            Map<String, String> callParams) throws TwilioRestException
   {
      authToken(authToken).accountSid(accountSid).setCallParams(
               callParams);
      TwilioRestClient client = new TwilioRestClient(getAccountSid(),
               getAuthToken());
      Account mainAccount = client.getAccount();
      CallFactory callFactory = mainAccount.getCallFactory();
      return callFactory.create(getCallParams());
   }

   public Map<String, String> getCallParams()
   {
      if (callParams == null)
         this.callParams = new HashMap<String, String>();
      return callParams;
   }

   public SimpleTwilioCaller setCallParams(Map<String, String> callParams)
   {
      this.callParams = callParams;
      return this;
   }

   public SimpleTwilioCaller addCallParam(String key, String value)
   {
      getCallParams().put(key, value);
      return this;
   }

   public String getFrom()
   {
      return from;
   }

   public SimpleTwilioCaller setFrom(String from)
   {
      getCallParams().put("From", from);
      return this;
   }

   public String getTo()
   {
      return to;
   }

   public SimpleTwilioCaller setTo(String to)
   {
      getCallParams().put("To", to);
      return this;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleTwilioCaller setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleTwilioCaller setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   public String getEndpoint()
   {
      return endpoint;
   }

   public SimpleTwilioCaller setEndpoint(String endpoint)
   {
      getCallParams().put("Url", endpoint);
      return this;
   }

   /*
    * FAST METHODS
    */
   public SimpleTwilioCaller from(String from)
   {
      return setFrom(from);
   }

   public SimpleTwilioCaller to(String to)
   {
      return setTo(to);
   }

   public SimpleTwilioCaller accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleTwilioCaller authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleTwilioCaller endpoint(String endpoint)
   {
      return setEndpoint(endpoint);
   }

   public SimpleTwilioCaller param(String key, String value)
   {
      return addCallParam(key, value);
   }

}