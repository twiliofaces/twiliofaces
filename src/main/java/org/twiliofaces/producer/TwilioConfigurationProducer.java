/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.producer;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.annotations.configuration.ApplicationSid;
import org.twiliofaces.annotations.configuration.TwilioNumber;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;
import org.twiliofaces.annotations.notification.AccountSid;
import org.twiliofaces.annotations.notification.ApiVersion;
import org.twiliofaces.api.configuration.TwilioAccount;
import org.twiliofaces.api.enums.TwilioRequestParamsEnum;
import org.twiliofaces.component.api.util.ELUtils;
import org.twiliofaces.extension.TwilioManager;

public class TwilioConfigurationProducer implements Serializable
{

   private static final long serialVersionUID = 1L;
   @Inject
   FacesContext facesContext;

   @Inject
   TwilioManager twilioManager;

   @Produces
   @AccountSid
   public String getAccountSid()
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
   @ApplicationSid
   public String getApplicationSid(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(ApplicationSid.class).account();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getApplicationSid();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               TwilioAccount twilioAccount = twilioManager.getAccount(account);
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
               .getAnnotation(TwilioNumber.class).account();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getTwilioNumber();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               TwilioAccount twilioAccount = twilioManager.getAccount(account);
               if (twilioAccount != null)
                  return twilioAccount.getTwilioNumber();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioSid
   public String getTwilioSid(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(TwilioSid.class).account();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getTwilioSid();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               TwilioAccount twilioAccount = twilioManager.getAccount(account);
               if (twilioAccount != null)
                  return twilioAccount.getTwilioSid();
            }
         }
      }
      return null;
   }

   @Produces
   @TwilioToken
   public String getTwilioToken(InjectionPoint injectionPoint)
   {
      String account = injectionPoint.getAnnotated()
               .getAnnotation(TwilioToken.class).account();
      if (twilioManager != null)
      {
         if (account == null || account.isEmpty() || account.equals("default"))
            return twilioManager.getTwilioToken();
         else
         {
            if (ELUtils.isElExpression(account))
            {
               account = ELUtils.resolveElExpression(account, facesContext);
               TwilioAccount twilioAccount = twilioManager.getAccount(account);
               if (twilioAccount != null)
                  return twilioAccount.getTwilioToken();
            }
         }
      }
      return null;
   }
}
