package org.twiliofaces.cdi.doers.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Recording;
import com.twilio.sdk.resource.list.RecordingList;

public class SimpleTranscriptionReporter
{
   Logger logger = Logger.getLogger(getClass().getName());
   private String accountSid;
   private String authToken;
   private Map<String, String> params;

   public SimpleTranscriptionReporter()
   {
   }

   public SimpleTranscriptionReporter(
            String accountSid, String authToken)
   {
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public RecordingList report()
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getRecordings(getParams());
   }

   public Recording report(String sid)
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getRecording(sid);
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleTranscriptionReporter setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleTranscriptionReporter setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleTranscriptionReporter setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleTranscriptionReporter addParam(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   // FAST METHODS
   public SimpleTranscriptionReporter accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleTranscriptionReporter authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleTranscriptionReporter param(String key, String value)
   {
      return addParam(key, value);
   }
}
