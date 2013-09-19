/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.producer.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TwilioRequestMap implements Serializable
{

   private static final long serialVersionUID = 1L;
   private Map<String, String> values;

   public Map<String, String> getValues()
   {
      if (this.values == null)
         this.values = new HashMap<String, String>();
      return values;
   }

   public void setValues(Map<String, String> values)
   {
      this.values = values;
   }

   public void setValue(String key, String value)
   {
      getValues().put(key, value);
   }

   @Override
   public String toString()
   {
      StringBuffer buffer = new StringBuffer();
      for (String key : getValues().keySet())
      {
         if (key != null && !key.isEmpty())
         {
            String value = getValues().get(key);
            if (value != null && !value.isEmpty())
               buffer.append(key + ": " + getValues().get(key) + "\n");
         }
      }
      return buffer.toString();
   }
}
