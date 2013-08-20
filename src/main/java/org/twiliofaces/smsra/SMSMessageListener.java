package org.twiliofaces.smsra;

import org.twiliofaces.smsra.model.SMSMessage;

public interface SMSMessageListener
{
   public void onMessage(SMSMessage smsMessage);
}