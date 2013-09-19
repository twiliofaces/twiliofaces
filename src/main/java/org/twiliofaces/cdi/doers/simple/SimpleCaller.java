/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.doers.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

public class SimpleCaller
{

   Logger logger = Logger.getLogger(getClass().getName());
   private String from;
   private String accountSid;
   private String authToken;

   private String to;
   private String endpoint;

   private Map<String, String> callParams;

   public SimpleCaller()
   {
   }

   public SimpleCaller(String from,
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

   public SimpleCaller setCallParams(Map<String, String> callParams)
   {
      this.callParams = callParams;
      return this;
   }

   public SimpleCaller addCallParam(String key, String value)
   {
      getCallParams().put(key, value);
      return this;
   }

   public String getFrom()
   {
      return from;
   }

   public SimpleCaller setFrom(String from)
   {
      getCallParams().put("From", from);
      return this;
   }

   public String getTo()
   {
      return to;
   }

   public SimpleCaller setTo(String to)
   {
      getCallParams().put("To", to);
      return this;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleCaller setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleCaller setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   public String getEndpoint()
   {
      return endpoint;
   }

   public SimpleCaller setEndpoint(String endpoint)
   {
      getCallParams().put("Url", endpoint);
      return this;
   }

   /*
    * FAST METHODS
    */
   public SimpleCaller from(String from)
   {
      return setFrom(from);
   }

   public SimpleCaller to(String to)
   {
      return setTo(to);
   }

   public SimpleCaller accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleCaller authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleCaller endpoint(String endpoint)
   {
      return setEndpoint(endpoint);
   }

   public SimpleCaller param(String key, String value)
   {
      return addCallParam(key, value);
   }

}