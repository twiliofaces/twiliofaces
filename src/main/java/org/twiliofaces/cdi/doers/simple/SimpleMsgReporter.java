package org.twiliofaces.cdi.doers.simple;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Message;
import com.twilio.sdk.resource.list.MessageList;

public class SimpleMsgReporter
{
   Logger logger = Logger.getLogger(getClass().getName());
   DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
   private String from;
   private String accountSid;
   private String authToken;
   private String to;
   private String status;
   private Date dateSent;
   private Date fromDateSent;
   private Date toDateSent;
   private Map<String, String> params;

   public SimpleMsgReporter()
   {
      // TODO Auto-generated constructor stub
   }

   public SimpleMsgReporter(String accountSid, String authToken)
   {
      this.authToken = authToken;
      this.accountSid = accountSid;
   }

   public MessageList report()
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getMessages(getParams());
   }

   public Message report(String sid)
   {
      TwilioRestClient client = new TwilioRestClient(getAccountSid(), getAuthToken());
      return client.getAccount().getMessage(sid);
   }

   public String getStatus()
   {
      return status;
   }

   public SimpleMsgReporter setStatus(String status)
   {
      getParams().put("Status", status);
      return this;
   }

   public Date getDateSent()
   {
      return dateSent;
   }

   public SimpleMsgReporter setDateSent(Date dateSent)
   {
      getParams().put("DateSent", format.format(dateSent));
      return this;
   }

   public Date getFromDateSent()
   {
      return fromDateSent;
   }

   public SimpleMsgReporter setFromDateSent(Date fromDateSent)
   {
      getParams().put("DateSent>", format.format(fromDateSent));
      return this;
   }

   public Date getToDateSent()
   {
      return toDateSent;
   }

   public SimpleMsgReporter setToDateSent(Date toDateSent)
   {
      getParams().put("DateSent<", format.format(toDateSent));
      return this;
   }

   public Map<String, String> getParams()
   {
      if (params == null)
         this.params = new HashMap<String, String>();
      return params;
   }

   public SimpleMsgReporter setParams(Map<String, String> params)
   {
      this.params = params;
      return this;
   }

   public SimpleMsgReporter addParam(String key, String value)
   {
      getParams().put(key, value);
      return this;
   }

   public String getFrom()
   {
      return from;
   }

   public SimpleMsgReporter setFrom(String from)
   {
      getParams().put("From", from);
      return this;
   }

   public String getTo()
   {
      return to;
   }

   public SimpleMsgReporter setTo(String to)
   {
      getParams().put("To", to);
      return this;
   }

   public String getAccountSid()
   {
      return accountSid;
   }

   public SimpleMsgReporter setAccountSid(String accountSid)
   {
      this.accountSid = accountSid;
      return this;
   }

   public String getAuthToken()
   {
      return authToken;
   }

   public SimpleMsgReporter setAuthToken(String authToken)
   {
      this.authToken = authToken;
      return this;
   }

   /*
    * FAST METHODS
    */
   public SimpleMsgReporter from(String from)
   {
      return setFrom(from);
   }

   public SimpleMsgReporter to(String to)
   {
      return setTo(to);
   }

   public SimpleMsgReporter accountSid(String accountSid)
   {
      return setAccountSid(accountSid);
   }

   public SimpleMsgReporter authToken(String authToken)
   {
      return setAuthToken(authToken);
   }

   public SimpleMsgReporter param(String key, String value)
   {
      return addParam(key, value);
   }

   public SimpleMsgReporter status(String status)
   {
      setStatus(status);
      return this;
   }

   public SimpleMsgReporter dateSent(Date dateSent)
   {
      setDateSent(dateSent);
      return this;
   }

   public SimpleMsgReporter fromDateSent(Date fromDateSent)
   {
      setFromDateSent(fromDateSent);
      return this;
   }

   public SimpleMsgReporter toDateSent(Date toDateSent)
   {
      setToDateSent(toDateSent);
      return this;
   }

   // queued, sending, sent, receiving, received, failed
   public SimpleMsgReporter queued()
   {
      return setStatus("queued");
   }

   public SimpleMsgReporter sending()
   {
      return setStatus("sending");
   }

   public SimpleMsgReporter sent()
   {
      return setStatus("sent");
   }

   public SimpleMsgReporter canceled()
   {
      return setStatus("sent");
   }

   public SimpleMsgReporter receiving()
   {
      return setStatus("receiving");
   }

   public SimpleMsgReporter received()
   {
      return setStatus("received");
   }

   public SimpleMsgReporter failed()
   {
      return setStatus("failed");
   }

}
