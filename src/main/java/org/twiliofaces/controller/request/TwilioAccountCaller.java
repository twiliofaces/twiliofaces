package org.twiliofaces.controller.request;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.cdi.extension.util.Account;
import org.twiliofaces.cdi.request.simple.SimpleTwilioCaller;
import org.twiliofaces.inject.configuration.TwilioAccount;

@Named
@RequestScoped
public class TwilioAccountCaller extends SimpleTwilioCaller
{

   public TwilioAccountCaller()
   {
   }

   @Inject
   public TwilioAccountCaller(@TwilioAccount Account twilioAccount)
   {
      super(twilioAccount.getTwilioNumber(), twilioAccount.getTwilioSid(), twilioAccount.getTwilioToken());
   }

}
