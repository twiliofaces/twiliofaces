/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.cdi.extension.util;

import java.io.Serializable;

public class KeyValue
         implements Serializable
{
   private static final long serialVersionUID = 1L;
   private String account;
   private String key;
   private String value;

   public KeyValue()
   {
   }

   public KeyValue(String account, String key, String value)
   {
      this.account = account;
      this.key = key;
      this.value = value;
   }

   public String getAccount()
   {
      return account;
   }

   public void setAccount(String account)
   {
      this.account = account;
   }

   public String getKey()
   {
      return key;
   }

   public void setKey(String key)
   {
      this.key = key;
   }

   public String getValue()
   {
      return value;
   }

   public void setValue(String value)
   {
      this.value = value;
   }

}
