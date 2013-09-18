/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.inject.context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.NormalScope;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@NormalScope
public @interface TwilioScope
{

}
