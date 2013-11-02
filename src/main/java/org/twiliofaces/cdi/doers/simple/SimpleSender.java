/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.doers.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;

public class SimpleSender
{

   Logger logger = Logger.getLogger(getClass().getName());
   private String accountSid;
   private String authToken;
   private List<String> recipients;
   private Map<String, String> params;

   public SimpleSender()
   {
   }

   public SimpleSender(String from,
            String accountSid, String authToken)
   {
      this.accountSid = accountSid;
      this.authToken = authToken;
      setFrom(from);
   }

   public String simpleSend() throws TwilioRestException
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(),
               getAuthToken());
      Account account = client.getAccount();
      SmsFactory smsFactory = account.getSmsFactory();
      return smsFactory.create(getParams()).getSid();
   }

   public String simpleSend(String from, String to, String body,
            String accountSid, String authToken) throws TwilioRestException
   {
      accountSid(accountSid).authToken(authToken).to(to)
               .from(from).body(body);
      return simpleSend();
   }

   public Sms send(String accountSid, String authToken,
            Map<String, String> params) throws TwilioRestException
   {
      setAccountSid(accountSid).setAuthToken(authToken).setParams(
               params);
      TwilioRestClient client = new TwilioRestClient(getAccountSid(),
               getAuthToken());
      Account account = client.getAccount();
      SmsFactory smsFactory = account.getSmsFactory();
      Sms sms = smsFactory.create(getParams());
      return sms;
   }

   public Sms send() throws TwilioRestException
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(),
               getAuthToken());
      Account account = client.getAccount();
      SmsFactory smsFactory = account.getSmsFactory();
      Sms sms = smsFactory.create(getParams());
      return sms;
   }

   public List<Sms> multipleSend() throws TwilioRestException
   {
      List<Sms> results = new ArrayList<Sms>();
      for (String recipient : getRecipients())
      {
         add("To", recipient);
         Sms sms = send(getAccountSid(), getAuthToken(), params);
         results.add(sms);
      }

      return results;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleSender setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleSender add(String key, String value)
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

   public SimpleSender setFrom(String from)
   {
      add("From", from);
      return this;
   }

   public String getTo()
   {
      return get("To");
   }

   public SimpleSender setTo(String to)
   {
      add("To", to);
      return this;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleSender setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleSender setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   public String getBody()
   {
      return get("Body");
   }

   public SimpleSender setBody(String body)
   {
      add("Body", body);
      return this;
   }

   public List<String> getRecipients()
   {
      if (recipients == null)
         this.recipients = new ArrayList<String>();
      return recipients;
   }

   public SimpleSender setRecipients(List<String> recipients)
   {
      this.recipients = recipients;
      return this;
   }

   public SimpleSender addRecipient(String recipient)
   {
      getRecipients().add(recipient);
      return this;
   }

   public String getMediaUrl()
   {
      return get("MediaUrl");
   }

   public SimpleSender setMediaUrl(String mediaUrl)
   {
      add("MediaUrl", mediaUrl);
      return this;
   }

   /*
    * FAST METHODS
    */
   public SimpleSender from(String from)
   {
      return setFrom(from);
   }

   public SimpleSender to(String to)
   {
      return setTo(to);
   }

   public SimpleSender accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleSender authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleSender body(String body)
   {
      return setBody(body);
   }

   public SimpleSender mediaUrl(String mediaUrl)
   {
      return setMediaUrl(mediaUrl);
   }

}
