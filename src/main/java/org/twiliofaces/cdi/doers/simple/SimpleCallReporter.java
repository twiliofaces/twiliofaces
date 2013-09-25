package org.twiliofaces.cdi.doers.simple;

import java.text.DateFormat;
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
   DateFormat format = new SimpleDateFormat("YYYY-MM-dd");
   private String from;
   private String accountSid;
   private String authToken;
   private String to;
   private String status;
   private Date startTime;
   private Date fromStartTime;
   private Date toStartTime;
   private String parentCallSid;
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
      return status;
   }

   public SimpleCallReporter setStatus(String status)
   {
      getParams().put("Status", status);
      return this;
   }

   public Date getStartTime()
   {
      return startTime;
   }

   public SimpleCallReporter setStartTime(Date startTime)
   {
      getParams().put("StartTime", format.format(startTime));
      return this;
   }

   public Date getFromStartTime()
   {
      return fromStartTime;
   }

   public SimpleCallReporter setFromStartTime(Date fromStartTime)
   {
      getParams().put("StartTime>", format.format(fromStartTime));
      return this;
   }

   public Date getToStartTime()
   {
      return toStartTime;
   }

   public SimpleCallReporter setToStartTime(Date toStartTime)
   {
      getParams().put("StartTime<", format.format(toStartTime));
      return this;
   }

   public String getParentCallSid()
   {
      return parentCallSid;
   }

   public SimpleCallReporter setParentCallSid(String parentCallSid)
   {
      getParams().put("ParentCallSid", parentCallSid);
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

   public SimpleCallReporter addParam(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   public String getFrom()
   {
      return from;
   }

   public SimpleCallReporter setFrom(String from)
   {
      getParams().put("From", from);
      return this;
   }

   public String getTo()
   {
      return to;
   }

   public SimpleCallReporter setTo(String to)
   {
      getParams().put("To", to);
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
      return addParam(key, value);
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
