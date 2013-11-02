package org.twiliofaces.cdi.doers.simple;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.list.CallList;

public class SimpleCallReporter
{
   Logger logger = Logger.getLogger(getClass().getName());
   DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   private String accountSid;
   private String authToken;
   private Map<String, String> params;

   public SimpleCallReporter()
   {
      // TODO Auto-generated constructor stub
   }

   public SimpleCallReporter(String accountSid, String authToken)
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
      return get("Status");
   }

   public SimpleCallReporter setStatus(String status)
   {
      add("Status", status);
      return this;
   }

   public Date getStartTime()
   {
      try
      {
         return format.parse(get("StartTime"));
      }
      catch (ParseException e)
      {
         return null;
      }
   }

   public SimpleCallReporter setStartTime(Date startTime)
   {
      add("StartTime", format.format(startTime));
      return this;
   }

   public Date getFromStartTime()
   {
      try
      {
         return format.parse(get("StartTime>"));
      }
      catch (ParseException e)
      {
         return null;
      }
   }

   public SimpleCallReporter setFromStartTime(Date fromStartTime)
   {
      add("StartTime>", format.format(fromStartTime));
      return this;
   }

   public Date getToStartTime()
   {
      try
      {
         return format.parse(get("StartTime<"));
      }
      catch (ParseException e)
      {
         return null;
      }
   }

   public SimpleCallReporter setToStartTime(Date toStartTime)
   {
      add("StartTime<", format.format(toStartTime));
      return this;
   }

   public String getParentCallSid()
   {
      return get("ParentCallSid");
   }

   public SimpleCallReporter setParentCallSid(String parentCallSid)
   {
      add("ParentCallSid", parentCallSid);
      return this;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleCallReporter setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleCallReporter add(String key, String value)
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

   public SimpleCallReporter setFrom(String from)
   {
      add("From", from);
      return this;
   }

   public String getTo()
   {
      return get("To");
   }

   public SimpleCallReporter setTo(String to)
   {
      add("To", to);
      return this;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleCallReporter setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleCallReporter setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   /*
    * FAST METHODS
    */
   public SimpleCallReporter from(String from)
   {
      return setFrom(from);
   }

   public SimpleCallReporter to(String to)
   {
      return setTo(to);
   }

   public SimpleCallReporter accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleCallReporter authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleCallReporter param(String key, String value)
   {
      return add(key, value);
   }

   public SimpleCallReporter status(String status)
   {
      setStatus(status);
      return this;
   }

   public SimpleCallReporter startTime(Date startTime)
   {
      setStartTime(startTime);
      return this;
   }

   public SimpleCallReporter fromStartTime(Date fromStartTime)
   {
      setFromStartTime(fromStartTime);
      return this;
   }

   public SimpleCallReporter toStartTime(Date toStartTime)
   {
      setToStartTime(toStartTime);
      return this;
   }

   public SimpleCallReporter parentCallSid(String parentCallSid)
   {
      setParentCallSid(parentCallSid);
      return this;
   }

   public SimpleCallReporter queued()
   {
      return setStatus("queued");
   }

   public SimpleCallReporter ringing()
   {
      return setStatus("ringing");
   }

   public SimpleCallReporter inProgress()
   {
      return setStatus("in-progress");
   }

   public SimpleCallReporter canceled()
   {
      return setStatus("canceled");
   }

   public SimpleCallReporter completed()
   {
      return setStatus("completed");
   }

   public SimpleCallReporter busy()
   {
      return setStatus("busy");
   }

   public SimpleCallReporter failed()
   {
      return setStatus("failed");
   }

   public SimpleCallReporter noAnswer()
   {
      return setStatus("no-answer");
   }

}
