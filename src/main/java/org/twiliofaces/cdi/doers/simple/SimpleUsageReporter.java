package org.twiliofaces.cdi.doers.simple;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.list.UsageRecordList;

public class SimpleUsageReporter
{
   Logger logger = Logger.getLogger(getClass().getName());
   DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   private String accountSid;
   private String authToken;
   private String category;
   private Date startDate;
   private Date endDate;
   private Map<String, String> params;

   public SimpleUsageReporter()
   {
      // TODO Auto-generated constructor stub
   }

   public SimpleUsageReporter(String accountSid, String authToken)
   {
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public UsageRecordList report()
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getUsageRecords(getParams());
   }

   public String getCategory()
   {
      return category;
   }

   public SimpleUsageReporter setCategory(String category)
   {
      getParams().put("Category", category);
      return this;
   }

   public Date getStartDate()
   {
      return startDate;
   }

   public SimpleUsageReporter setStartDate(Date startDate)
   {
      getParams().put("StartDate", format.format(startDate));
      return this;
   }

   public Date getEndDate()
   {
      return endDate;
   }

   public SimpleUsageReporter setEndDate(Date endDate)
   {
      getParams().put("EndDate", format.format(endDate));
      return this;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleUsageReporter setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleUsageReporter addParam(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleUsageReporter setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleUsageReporter setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   /*
    * FAST METHODS
    */
   public SimpleUsageReporter accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleUsageReporter authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleUsageReporter param(String key, String value)
   {
      return addParam(key, value);
   }

   public SimpleUsageReporter category(String category)
   {
      setCategory(category);
      return this;
   }

   public SimpleUsageReporter startDate(Date startDate)
   {
      setStartDate(startDate);
      return this;
   }

   public SimpleUsageReporter endDate(Date endDate)
   {
      setEndDate(endDate);
      return this;
   }

   public SimpleUsageReporter calls()
   {
      return setCategory("calls");
   }

   public SimpleUsageReporter sms()
   {
      return setCategory("sms");
   }

   public SimpleUsageReporter phonenumbers()
   {
      return setCategory("phonenumbers");
   }

   public SimpleUsageReporter recordings()
   {
      return setCategory("recordings");
   }

   public SimpleUsageReporter transcriptions()
   {
      return setCategory("transcriptions");
   }

   public SimpleUsageReporter totalprice()
   {
      return setCategory("totalprice");
   }

}
