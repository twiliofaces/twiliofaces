/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.producer;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.annotations.configuration.ApplicationSid;
import org.twiliofaces.annotations.configuration.TwilioClientToken;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;

import com.twilio.sdk.client.TwilioCapability;
import com.twilio.sdk.client.TwilioCapability.DomainException;

public class TwilioCapabilityProducer implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Inject
   FacesContext facesContext;

   @Inject
   @TwilioSid
   String twilioSid;

   @Inject
   @TwilioToken
   String twilioToken;

   @Inject
   @ApplicationSid
   String applicationSid;

   @Produces
   @TwilioClientToken
   /**
    * 
    * @param injectionPoint: you can use a resolvable expression like #{loginController.username}" or simple string like 'client'
    * @return
    */
   public String getTwilioClientToken(InjectionPoint injectionPoint)
   {
      TwilioCapability capability = new TwilioCapability(twilioSid,
               twilioToken);
      if (applicationSid != null && !applicationSid.isEmpty())
         capability.allowClientOutgoing(applicationSid);

      String client = injectionPoint.getAnnotated()
               .getAnnotation(TwilioClientToken.class).client();
      if (client == null)
         return "";
      if (client != null && client.trim().startsWith("#{") && client.trim().endsWith("}"))
      {
         Application app = facesContext.getApplication();
         facesContext.getViewRoot();
         ExpressionFactory exprFactory = app.getExpressionFactory();
         ELContext elContext = facesContext.getELContext();
         ValueExpression valExpr = exprFactory.createValueExpression(
                  elContext, client, Object.class);
         client = (String) valExpr.getValue(elContext);
      }
      capability.allowClientIncoming(client);

      try
      {
         return capability.generateToken();
      }
      catch (DomainException e)
      {
         e.printStackTrace();
      }
      return null;
   }
}
