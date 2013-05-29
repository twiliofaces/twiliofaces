/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.extension;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.twiliofaces.annotations.notification.CallSid;
import org.twiliofaces.annotations.scope.TwilioScope;

public class TwilioContext implements Context
{

   private final BeanManager beanManager;

   public TwilioContext(BeanManager beanManager)
   {
      this.beanManager = beanManager;
   }

   public <T> T get(final Contextual<T> contextual)
   {
      return null;
   }

   public <T> T get(final Contextual<T> contextual,
            final CreationalContext<T> creationalContext)
   {
      assertActive();
      Bean<T> bean = (Bean<T>) contextual;
      T beanInstance = bean.create(creationalContext);
      String callSid = getCallSid(beanInstance);
      T toReturn = getTwilioManager().getOrCreate(callSid, beanInstance);
      if (!toReturn.equals(beanInstance))
      {
         contextual.destroy(beanInstance, creationalContext);
      }
      return toReturn;
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   private TwilioManager getTwilioManager()
   {
      Bean phBean = (Bean) beanManager.getBeans(TwilioManager.class)
               .iterator().next();
      CreationalContext cc = beanManager.createCreationalContext(phBean);
      TwilioManager bean = (TwilioManager) beanManager.getReference(phBean,
               TwilioManager.class, cc);
      return bean;
   }

   private String getCallSid(Object instance)
   {
      try
      {
         Field[] fields = instance.getClass().getDeclaredFields();
         for (Field field : fields)
         {
            field.setAccessible(true);
            if (field.isAnnotationPresent(CallSid.class))
            {
               Object value = field.get(instance);
               return (String) value;
            }
         }
         if (TwilioScoped.class.isAssignableFrom(instance.getClass()))
         {
            TwilioScoped twScoped = (TwilioScoped) instance;
            if (twScoped != null && twScoped.getCallSid() != null)
            {
               return twScoped.getCallSid();
            }
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return null;
   }

   @Override
   public Class<? extends Annotation> getScope()
   {
      return TwilioScope.class;
   }

   @Override
   public boolean isActive()
   {
      return true;
   }

   private void assertActive()
   {
      if (!isActive())
      {
         throw new ContextNotActiveException(
                  "Twilio context with scope annotation @TwilioScope is not active with respect to the current thread");
      }
   }

}
