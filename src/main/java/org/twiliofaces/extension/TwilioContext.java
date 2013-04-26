package org.twiliofaces.extension;

import java.lang.annotation.Annotation;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.twiliofaces.annotations.TwilioScope;

public class TwilioContext implements Context {

	private final BeanManager beanManager;

	public TwilioContext(BeanManager beanManager) {
		this.beanManager = beanManager;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(final Contextual<T> contextual) {
		Bean<T> bean = (Bean<T>) contextual;
		System.out.println("bean: " + bean.getName());
		String sid = getCallSid(bean);
		Object variable = null;
		if (sid != null) {
			variable = getTwilioManager().getVariable(sid);
		}
		if (variable != null) {
			return (T) variable;
		} else {
			return null;
		}
	}

	private TwilioManager getTwilioManager() {
		Bean phBean = (Bean) beanManager.getBeans(TwilioManager.class)
				.iterator().next();
		CreationalContext cc = beanManager.createCreationalContext(phBean);
		TwilioManager bean = (TwilioManager) beanManager.getReference(phBean,
				TwilioManager.class, cc);
		return bean;
	}

	@SuppressWarnings({ "unchecked" })
	public <T> T get(final Contextual<T> contextual,
			final CreationalContext<T> creationalContext) {
		assertActive();

		Bean<T> bean = (Bean<T>) contextual;
		System.out.println("bean: " + bean.getName());
		String sid = getCallSid(bean);
		Object variable = null;
		if (sid != null) {
			variable = getTwilioManager().getVariable(sid);
		}
		if (variable != null) {
			return (T) variable;
		} else {
			T beanInstance = bean.create(creationalContext);
			getTwilioManager().setVariable(getCallSid(beanInstance),
					beanInstance);
			return beanInstance;
		}

	}

	private String getCallSid(Object instance) {
		try {
			TwilioScoped twScoped = (TwilioScoped) instance;
			if (twScoped != null && twScoped.getCallSid() != null) {
				return twScoped.getCallSid();
			}
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Class<? extends Annotation> getScope() {
		System.out.println("getScope TwilioScope.class");
		return TwilioScope.class;
	}

	@Override
	public boolean isActive() {
		if (getTwilioManager() != null
				&& getTwilioManager().getTwilioScopedMap() != null)
			return true;
		return false;
	}

	private void assertActive() {
		if (!isActive()) {
			throw new ContextNotActiveException(
					"Twilio context with scope annotation @TwilioScope is not active with respect to the current thread");
		}
	}

}
