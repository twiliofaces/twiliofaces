package org.twiliofaces.cdi.doers.simple;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Notification;
import com.twilio.sdk.resource.list.NotificationList;

public class SimpleNotificationReporter
{
   Logger logger = Logger.getLogger(getClass().getName());
   DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   private String accountSid;
   private String authToken;
   private String log;
   private Date messageDate;
   private Date fromMessageDate;
   private Date toMessageDate;
   private Map<String, String> params;

   public SimpleNotificationReporter()
   {
   }

   public SimpleNotificationReporter(
            String accountSid, String authToken)
   {
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public NotificationList report()
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getNotifications(getParams());
   }

   public Notification report(String sid)
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getNotification(sid);
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleNotificationReporter setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleNotificationReporter setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   public String getLog()
   {
      return log;
   }

   public SimpleNotificationReporter setLog(String log)
   {
      getParams().put("Log", log);
      return this;
   }

   public Date getMessageDate()
   {
      return messageDate;
   }

   public SimpleNotificationReporter setMessageDate(Date messageDate)
   {
      getParams().put("MessageDate", format.format(messageDate));
      return this;
   }

   public Date getFromMessageDate()
   {
      return fromMessageDate;
   }

   public SimpleNotificationReporter setFromMessageDate(Date fromMessageDate)
   {
      getParams().put("MessageDate>", format.format(messageDate));
      return this;
   }

   public Date getToMessageDate()
   {
      return toMessageDate;
   }

   public SimpleNotificationReporter setToMessageDate(Date toMessageDate)
   {
      getParams().put("MessageDate<", format.format(messageDate));
      return this;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleNotificationReporter setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleNotificationReporter addParam(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   // FAST METHODS
   public SimpleNotificationReporter accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleNotificationReporter authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleNotificationReporter param(String key, String value)
   {
      return addParam(key, value);
   }

}
