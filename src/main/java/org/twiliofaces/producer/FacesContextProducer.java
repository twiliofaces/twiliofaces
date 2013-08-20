/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.producer;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer
{

   @Produces
   FacesContext getFacesContext()
   {

      return FacesContext.getCurrentInstance();

   }

}