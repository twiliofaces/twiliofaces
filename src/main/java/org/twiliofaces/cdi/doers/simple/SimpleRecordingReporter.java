package org.twiliofaces.cdi.doers.simple;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Recording;
import com.twilio.sdk.resource.list.RecordingList;

public class SimpleRecordingReporter
{
   Logger logger = Logger.getLogger(getClass().getName());
   DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   private String accountSid;
   private String authToken;
   private Map<String, String> params;

   public SimpleRecordingReporter()
   {
   }

   public SimpleRecordingReporter(
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

   public SimpleRecordingReporter setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleRecordingReporter setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   public String getLog()
   {
      return get("Log");
   }

   public SimpleRecordingReporter setLog(String log)
   {
      add("Log", log);
      return this;
   }

   public Date getDateCreated()
   {
      try
      {
         return format.parse(get("DateCreated"));
      }
      catch (ParseException e)
      {
         e.printStackTrace();
         return null;
      }
   }

   public SimpleRecordingReporter setDateCreated(Date dateCreated)
   {
      add("DateCreated", format.format(dateCreated));
      return this;
   }

   public Date getFromDateCreated()
   {
      try
      {
         return format.parse(get("DateCreated>"));
      }
      catch (ParseException e)
      {
         e.printStackTrace();
         return null;
      }
   }

   public SimpleRecordingReporter setFromDateCreated(Date fromDateCreated)
   {
      add("DateCreated>", format.format(fromDateCreated));
      return this;
   }

   public Date getToDateCreated()
   {
      try
      {
         return format.parse(get("DateCreated<"));
      }
      catch (ParseException e)
      {
         e.printStackTrace();
         return null;
      }
   }

   public SimpleRecordingReporter setToDateCreated(Date toDateCreated)
   {
      add("DateCreated<", format.format(toDateCreated));
      return this;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleRecordingReporter setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleRecordingReporter add(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   public String get(String key)
   {
      return get(key);
   }

   // FAST METHODS
   public SimpleRecordingReporter accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleRecordingReporter authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleRecordingReporter param(String key, String value)
   {
      return add(key, value);
   }
}
