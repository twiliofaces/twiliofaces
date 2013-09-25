/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.web.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.twiliofaces.cdi.extension.TwilioManager;
import org.twiliofaces.faces.component.api.util.Constants;
import org.twiliofaces.web.listener.util.TwilioConfigurationEnum;

@WebListener
public class StartupListener implements ServletContextListener
{

   Logger logger = Logger.getLogger(getClass().getName());

   @Inject
   TwilioManager twilioManager;

   @Override
   public void contextDestroyed(ServletContextEvent sce)
   {
      logger.info("context destroyed");
   }

   @Override
   public void contextInitialized(ServletContextEvent sce)
   {
      logger.info("context Initialized");
      if (twilioManager.getDefaultAccount() == null)
      {
         setApplicationSid(sce.getServletContext());
         setTwilioNumber(sce.getServletContext());
         setTwilioSid(sce.getServletContext());
         setTwilioToken(sce.getServletContext());
      }
      else
      {
         logger.info("twilio default account is already configired");
      }
      logger.log(Level.INFO, "Twiliofaces {0} is on!", Constants.VERSION);
   }

   public void setApplicationSid(ServletContext sc)
   {
      if (sc != null && sc.getInitParameter(
               TwilioConfigurationEnum.APPLICATION_SID.name()) != null && !sc.getInitParameter(
               TwilioConfigurationEnum.APPLICATION_SID.name()).isEmpty())
         twilioManager.setApplicationSid(sc.getInitParameter(
                  TwilioConfigurationEnum.APPLICATION_SID.name()));
   }

   public void setTwilioNumber(ServletContext sc)
   {
      if (sc != null && sc.getInitParameter(
               TwilioConfigurationEnum.TWILIO_NUMBER.name()) != null && !sc.getInitParameter(
               TwilioConfigurationEnum.TWILIO_NUMBER.name()).isEmpty())
         twilioManager.setTwilioNumber(sc.getInitParameter(
                  TwilioConfigurationEnum.TWILIO_NUMBER.name()));
   }

   public void setTwilioSid(ServletContext sc)
   {
      if (sc != null && sc.getInitParameter(
               TwilioConfigurationEnum.TWILIO_SID.name()) != null && !sc.getInitParameter(
               TwilioConfigurationEnum.TWILIO_SID.name()).isEmpty())
         twilioManager.setTwilioSid(sc.getInitParameter(
                  TwilioConfigurationEnum.TWILIO_SID.name()));
   }

   public void setTwilioToken(ServletContext sc)
   {
      if (sc != null && sc.getInitParameter(
               TwilioConfigurationEnum.TWILIO_TOKEN.name()) != null && !sc.getInitParameter(
               TwilioConfigurationEnum.TWILIO_TOKEN.name()).isEmpty())
         twilioManager.setTwilioToken(sc.getInitParameter(
                  TwilioConfigurationEnum.TWILIO_TOKEN.name()));
   }

}
