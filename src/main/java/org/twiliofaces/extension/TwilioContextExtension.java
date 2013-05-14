/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.extension;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

import org.twiliofaces.annotations.TwilioScope;

public class TwilioContextExtension implements Extension {
	public void afterBeanDiscovery(@Observes AfterBeanDiscovery event,
			BeanManager manager) {
		// System.out.println("afterBeanDiscovery: " + event.toString());
		event.addContext(new TwilioContext(manager));
	}

	public void addScope(@Observes final BeforeBeanDiscovery event) {
		event.addScope(TwilioScope.class, true, true);
		// System.out.println("addScope: " + event.toString());
	}

}
