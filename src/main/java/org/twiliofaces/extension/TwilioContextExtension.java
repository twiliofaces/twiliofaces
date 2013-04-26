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
		event.addContext(new TwilioContext());
	}

	public void addScope(@Observes final BeforeBeanDiscovery event) {
		event.addScope(TwilioScope.class, true, true);
	}

}
