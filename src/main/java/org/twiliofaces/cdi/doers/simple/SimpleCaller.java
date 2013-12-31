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
   private String accountSid;
   private String authToken;

   private Map<String, String> params;

   public SimpleCaller()
   {
   }

   public SimpleCaller(String from,
            String accountSid, String authToken)
   {
      setFrom(from);
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public String simpleCall(String from, String to, String accountSid,
            String authToken, String url) throws TwilioRestException
   {
      from(from).to(to).authToken(authToken)
               .accountSid(accountSid).url(url);
      return call();
   }

   public String call() throws TwilioRestException
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(),
               getAuthToken());
      Account mainAccount = client.getAccount();
      CallFactory callFactory = mainAccount.getCallFactory();

      Call call = callFactory.create(getParams());
      return call.getSid();
   }

   public Call call(String accountSid, String authToken,
            Map<String, String> params) throws TwilioRestException
   {
      authToken(authToken).accountSid(accountSid).setParams(
               params);
      TwilioRestClient client = new TwilioRestClient(getAccountSid(),
               getAuthToken());
      Account mainAccount = client.getAccount();
      CallFactory callFactory = mainAccount.getCallFactory();
      return callFactory.create(getParams());
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleCaller setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleCaller add(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   public String get(String key)
   {
      return get(key);
   }

   public String getFrom()
   {
      return get("From");
   }

   public SimpleCaller setFrom(String from)
   {
      add("From", from);
      return this;
   }

   public String getTo()
   {
      return get("To");
   }

   public SimpleCaller setTo(String to)
   {
      add("To", to);
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

   public String getUrl()
   {
      return get("Url");
   }

   public SimpleCaller setUrl(String url)
   {
      add("Url", url);
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

   public SimpleCaller url(String url)
   {
      return setUrl(url);
   }

   public SimpleCaller param(String key, String value)
   {
      return add(key, value);
   }

}