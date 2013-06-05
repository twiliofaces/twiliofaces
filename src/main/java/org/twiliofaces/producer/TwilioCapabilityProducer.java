/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.producer;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.annotations.configuration.TwilioClientToken;
import org.twiliofaces.request.TwilioClient;

@RequestScoped
public class TwilioCapabilityProducer implements Serializable
{
   Logger logger = Logger.getLogger(getClass().getName());
   private static final long serialVersionUID = 1L;

   @Inject
   FacesContext facesContext;

   @Inject
   TwilioClient twilioClient;

   @Produces
   @TwilioClientToken
   /**
    * 
    * @param injectionPoint: you can use a resolvable expression like #{loginController.username}" or simple string like 'client'
    * @return
    */
   public String getTwilioClientToken(InjectionPoint injectionPoint)
   {
      String client = injectionPoint.getAnnotated()
               .getAnnotation(TwilioClientToken.class).client();
      if (client == null)
         return "";
      if (client != null && client.trim().startsWith("#{") && client.trim().endsWith("}"))
      {
         Application app = facesContext.getApplication();
         ELContext elContext = facesContext.getELContext();
         logger.info("BEFORE: " + client);
         ExpressionFactory exprFactory = app.getExpressionFactory();
         ValueExpression valExpr = exprFactory.createValueExpression(
                  elContext, client, Object.class);
         client = (String) valExpr.getValue(elContext);
         logger.info("AFTER: " + client);
      }
      return twilioClient.generateToken(client);
   }
}
