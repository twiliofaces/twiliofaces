/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.producer;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.cdi.extension.TwilioManager;
import org.twiliofaces.cdi.extension.util.Account;
import org.twiliofaces.cdi.producer.util.ELUtils;
import org.twiliofaces.cdi.producer.util.TwilioRequestParamsEnum;
import org.twiliofaces.inject.configuration.TwilioAccount;
import org.twiliofaces.inject.configuration.TwilioAccountSid;
import org.twiliofaces.inject.configuration.TwilioAuthToken;
import org.twiliofaces.inject.configuration.TwilioConnectAppSid;
import org.twiliofaces.inject.configuration.TwilioNumber;
import org.twiliofaces.inject.notification.ApiVersion;

public class TwilioConfigurationProducer implements Serializable
{

   private static final long serialVersionUID = 1L;
   @Inject
   FacesContext facesContext;

   @Inject
   TwilioManager twilioManager;

   @Produces
   @TwilioAccountSid
   public String getTwilioAccountSid()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.AccountSid.name());
      }
      return null;
   }

   @Produces
   @ApiVersion
   public String getApiVersion()
   {
      if (facesContext != null && facesContext.getExternalContext() != null
               && facesContext.getExternalContext().getRequestParameterMap() != null)
      {
         return facesContext.getExternalContext().getRequestParameterMap()
                  .get(TwilioRequestParamsEnum.ApiVersion.name());
      }
      return null;
   }

   @Produces
   @TwilioConnectAppSid
   public String getTwilioConnectAppSid(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(TwilioConnectAppSid.class).accountName();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getApplicationSid();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               Account twilioAccount = twilioManager.getAccount(account);
               if (twilioAccount != null)
                  return twilioAccount.getApplicationSid();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioNumber
   public String getTwilioNumber(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(TwilioNumber.class).accountName();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getTwilioNumber();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               Account twilioAccount = twilioManager.getAccount(account);
               if (twilioAccount != null)
                  return twilioAccount.getTwilioNumber();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAccountSid
   public String getTwilioAccountSid(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccountSid.class).accountName();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getTwilioSid();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               Account twilioAccount = twilioManager.getAccount(account);
               if (twilioAccount != null)
                  return twilioAccount.getTwilioSid();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAuthToken
   public String getTwilioAuthToken(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAuthToken.class).accountName();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getTwilioToken();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               Account twilioAccount = twilioManager.getAccount(account);
               if (twilioAccount != null)
                  return twilioAccount.getTwilioToken();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioAccount
   public Account getTwilioAccount(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(TwilioAccount.class).accountName();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.toLowerCase().equals("default"))
            return twilioManager.getDefaultAccount();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               return twilioManager.getAccount(account);
            }
         }
      }
      return null;
   }
}
