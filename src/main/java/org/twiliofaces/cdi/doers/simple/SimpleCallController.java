package org.twiliofaces.cdi.doers.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Call;

public class SimpleCallController
{
   Logger logger = Logger.getLogger(getClass().getName());
   private String accountSid;
   private String authToken;

   private String callSid;
   private String statusCallbackMethod;

   /*
    * Url Method Status FallbackUrl FallbackMethod StatusCallback StatusCallbackMethod
    */
   private Map<String, String> params;

   public SimpleCallController()
   {
      // TODO Auto-generated constructor stub
   }

   public SimpleCallController(String accountSid, String authToken)
   {
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public void update()
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      Call call = client.getAccount().getCall(getCallSid());
      try
      {
         call.update(getParams());
      }
      catch (TwilioRestException e)
      {
         e.printStackTrace();
      }
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleCallController setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleCallController add(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   public String get(String key)
   {
      return getParams().get(key);
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleCallController setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleCallController setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   public String getStatus()
   {
      return get("Status");
   }

   public SimpleCallController setStatus(String status)
   {
      add("Status", status);
      return this;
   }

   public String getUrl()
   {
      return get("Url");
   }

   public SimpleCallController setUrl(String url)
   {
      add("Url", url);
      return this;
   }

   public String getMethod()
   {
      return get("Method");
   }

   public SimpleCallController setMethod(String method)
   {
      add("Method", method);
      return this;
   }

   public String getFallbackUrl()
   {
      return get("FallbackUrl");
   }

   public SimpleCallController setFallbackUrl(String fallbackUrl)
   {
      add("FallbackUrl", fallbackUrl);
      return this;
   }

   public String getFallbackMethod()
   {
      return get("FallbackMethod");
   }

   public SimpleCallController setFallbackMethod(String fallbackMethod)
   {
      add("FallbackMethod", fallbackMethod);
      return this;
   }

   public String getStatusCallbackMethod()
   {
      return get("StatusCallbackMethod");
   }

   public SimpleCallController setStatusCallbackMethod(String statusCallbackMethod)
   {
      add("StatusCallbackMethod", statusCallbackMethod);
      return this;
   }

   public String getStatusCallback()
   {
      return get("StatusCallback");
   }

   public SimpleCallController setStatusCallback(String statusCallback)
   {
      add("StatusCallback", statusCallback);
      return this;
   }

   /*
    * FAST METHODS
    */

   public SimpleCallController accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleCallController authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleCallController param(String key, String value)
   {
      return add(key, value);
   }

   public SimpleCallController status(String status)
   {
      setStatus(status);
      return this;
   }

   public SimpleCallController canceled()
   {
      return setStatus("canceled");
   }

   public SimpleCallController completed()
   {
      return setStatus("completed");
   }

   public SimpleCallController fallback(String fallbackUrl, String fallbackMethod)
   {
      setFallbackMethod(fallbackMethod).setFallbackUrl(fallbackUrl);
      return this;
   }

   public SimpleCallController fallbackUrl(String fallbackUrl)
   {
      setFallbackUrl(fallbackUrl);
      return this;
   }

   public SimpleCallController fallbackMethod(String fallbackMethod)
   {
      setFallbackMethod(fallbackMethod);
      return this;
   }

   public SimpleCallController statusCallback(String statusCallback, String statusCallbackMethod)
   {
      setStatusCallback(statusCallbackMethod).setStatusCallbackMethod(statusCallbackMethod);
      return this;
   }

   public SimpleCallController statusCallback(String statusCallback)
   {
      setStatusCallback(statusCallbackMethod);
      return this;
   }

   public SimpleCallController statusCallbackMethod(String statusCallbackMethod)
   {
      setStatusCallbackMethod(statusCallbackMethod);
      return this;
   }

   public String getCallSid()
   {
      return callSid;
   }

   public void setCallSid(String callSid)
   {
      this.callSid = callSid;
   }

}
