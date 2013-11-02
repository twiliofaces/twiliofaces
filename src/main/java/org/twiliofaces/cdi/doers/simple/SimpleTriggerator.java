package org.twiliofaces.cdi.doers.simple;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.UsageTriggerFactory;
import com.twilio.sdk.resource.instance.UsageTrigger;
import com.twilio.sdk.resource.list.UsageTriggerList;

public class SimpleTriggerator
{
   Logger logger = Logger.getLogger(getClass().getName());
   DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   private String accountSid;
   private String authToken;

   private Map<String, String> params;

   public SimpleTriggerator()
   {
   }

   public SimpleTriggerator(String accountSid, String authToken)
   {
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public UsageTriggerList report()
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getUsageTriggers(getParams());
   }

   public UsageTrigger report(String sid)
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getUsageTrigger(sid);
   }

   public UsageTrigger update(String sid) throws TwilioRestException
   {
      UsageTrigger usageTrigger = report(sid);
      usageTrigger.update(getParams());
      return usageTrigger;
   }

   public UsageTrigger create() throws TwilioRestException
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      UsageTriggerFactory usageTriggerFactory = client.getAccount().getUsageTriggerFactory();
      UsageTrigger usageTrigger = usageTriggerFactory.create(getParams());
      return usageTrigger;
   }

   public String getUsageCategory()
   {
      return get("UsageCategory");
   }

   public SimpleTriggerator setUsageCategory(String usageCategory)
   {
      add("UsageCategory", usageCategory);
      return this;
   }

   public String getTriggerValue()
   {
      return get("TriggerValue");
   }

   public SimpleTriggerator setTriggerValue(String triggerValue)
   {
      add("TriggerValue", triggerValue);
      return this;
   }

   public String getCallbackUrl()
   {
      return get("CallbackUrl");
   }

   public SimpleTriggerator setCallbackUrl(String callbackUrl)
   {
      add("CallbackUrl", callbackUrl);
      return this;
   }

   public String getFriendlyName()
   {
      return get("FriendlyName");
   }

   public SimpleTriggerator setFriendlyName(String friendlyName)
   {
      add("FriendlyName", friendlyName);
      return this;
   }

   public String getRecurring()
   {
      return get("Recurring");
   }

   public SimpleTriggerator setRecurring(String recurring)
   {
      add("Recurring", recurring);
      return this;
   }

   public String getTriggerBy()
   {
      return get("TriggerBy");
   }

   public SimpleTriggerator setTriggerBy(String triggerBy)
   {
      add("TriggerBy", triggerBy);
      return this;
   }

   public String getCallbackMethod()
   {
      return get("CallbackMethod");
   }

   public SimpleTriggerator setCallbackMethod(String callbackMethod)
   {
      add("CallbackMethod", callbackMethod);
      return this;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleTriggerator setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleTriggerator add(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   public String get(String key)
   {
      return get(key);
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleTriggerator setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleTriggerator setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   /*
    * FAST METHODS
    */
   public SimpleTriggerator accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleTriggerator authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleTriggerator param(String key, String value)
   {
      return add(key, value);
   }

   public SimpleTriggerator usageCategory(String category)
   {
      setUsageCategory(category);
      return this;
   }

   public SimpleTriggerator triggerValue(String triggerValue)
   {
      setTriggerValue(triggerValue);
      return this;
   }

   public SimpleTriggerator triggerBy(String triggerBy)
   {
      setTriggerBy(triggerBy);
      return this;
   }

   public SimpleTriggerator callbackMethod(String callbackMethod)
   {
      setCallbackMethod(callbackMethod);
      return this;
   }

   public SimpleTriggerator post()
   {
      setCallbackMethod("POST");
      return this;
   }

   public SimpleTriggerator get()
   {
      setCallbackMethod("GET");
      return this;
   }

   public SimpleTriggerator byCount()
   {
      setTriggerBy("count");
      return this;
   }

   public SimpleTriggerator byUsage()
   {
      setTriggerBy("usage");
      return this;
   }

   public SimpleTriggerator byPrice()
   {
      setTriggerBy("price");
      return this;
   }

   public SimpleTriggerator callbackUrl(String callbackUrl)
   {
      setCallbackUrl(callbackUrl);
      return this;
   }

   public SimpleTriggerator friendlyName(String friendlyName)
   {
      setFriendlyName(friendlyName);
      return this;
   }

   public SimpleTriggerator recurring(String recurring)
   {
      setRecurring(recurring);
      return this;
   }

   public SimpleTriggerator daily()
   {
      setRecurring("daily");
      return this;
   }

   public SimpleTriggerator monthly()
   {
      setRecurring("monthly");
      return this;
   }

   public SimpleTriggerator yearly()
   {
      setRecurring("yearly");
      return this;
   }

   public SimpleTriggerator calls()
   {
      return setUsageCategory("calls");
   }

   public SimpleTriggerator sms()
   {
      return setUsageCategory("sms");
   }

   public SimpleTriggerator phonenumbers()
   {
      return setUsageCategory("phonenumbers");
   }

   public SimpleTriggerator recordings()
   {
      return setUsageCategory("recordings");
   }

   public SimpleTriggerator transcriptions()
   {
      return setUsageCategory("transcriptions");
   }

   public SimpleTriggerator totalprice()
   {
      return setUsageCategory("totalprice");
   }

}
