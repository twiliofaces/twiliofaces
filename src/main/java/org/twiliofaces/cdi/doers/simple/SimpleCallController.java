package org.twiliofaces.cdi.doers.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.list.CallList;

public class SimpleCallController
{
   Logger logger = Logger.getLogger(getClass().getName());
   private String accountSid;
   private String authToken;

   private String url;
   private String method;
   private String status;
   private String fallbackUrl;
   private String fallbackMethod;
   private String statusCallback;
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

   public CallList report()
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getCalls(getParams());
   }

   public Call report(String sid)
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getCall(sid);
   }

   public String getStatus()
   {
      return status;
   }

   public SimpleCallController setStatus(String status)
   {
      getParams().put("Status", status);
      return this;
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

   public SimpleCallController addParam(String key, String value)
   {
      getParams().put(key, value);
      return this;
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

   public String getUrl()
   {
      return url;
   }

   public SimpleCallController setUrl(String url)
   {
      addParam("Url", url);
      return this;
   }

   public String getMethod()
   {
      return method;
   }

   public SimpleCallController setMethod(String method)
   {
      addParam("Method", method);
      return this;
   }

   public String getFallbackUrl()
   {
      return fallbackUrl;
   }

   public SimpleCallController setFallbackUrl(String fallbackUrl)
   {
      addParam("FallbackUrl", fallbackUrl);
      return this;
   }

   public String getFallbackMethod()
   {
      return fallbackMethod;
   }

   public SimpleCallController setFallbackMethod(String fallbackMethod)
   {
      addParam("FallbackMethod", fallbackMethod);
      return this;
   }

   public String getStatusCallbackMethod()
   {
      return statusCallbackMethod;
   }

   public SimpleCallController setStatusCallbackMethod(String statusCallbackMethod)
   {
      addParam("StatusCallbackMethod", statusCallbackMethod);
      return this;
   }

   public String getStatusCallback()
   {
      return statusCallback;
   }

   public SimpleCallController setStatusCallback(String statusCallback)
   {
      addParam("StatusCallback", statusCallback);
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
      return addParam(key, value);
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

}
