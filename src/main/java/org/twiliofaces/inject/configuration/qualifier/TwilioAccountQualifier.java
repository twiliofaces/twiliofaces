package org.twiliofaces.inject.configuration.qualifier;

import javax.enterprise.util.AnnotationLiteral;

import org.twiliofaces.inject.configuration.TwilioAccount;

public abstract class TwilioAccountQualifier
         extends AnnotationLiteral<TwilioAccount>
         implements TwilioAccount
{
   private static final long serialVersionUID = 1L;

   public TwilioAccountQualifier()
   {
      // TODO Auto-generated constructor stub
   }

   public static TwilioAccount getTwilioAccount(final String accountName)
   {
      TwilioAccount twilioAccount = new TwilioAccountQualifier()
      {
         private static final long serialVersionUID = 1L;

         public String accountName()
         {
            return accountName;
         }
      };
      return twilioAccount;
   }
}
