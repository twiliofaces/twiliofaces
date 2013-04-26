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
		String variableName = bean.getName();
		System.out.println("get VAR NAME: " + variableName);
		String sid = getCallSid(bean);
		Object variable = null;
		if (sid != null) {
			variable = getTwilioManager().getVariable(sid);
		}
		if (variable != null) {
			System.out.println("get VALUE VAR: " + variable);
			describe(variable, "GET SIMPLE ");
			return (T) variable;
		} else {
			System.out.println("GET NULL");
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
		System.out.println("getcontextual: " + contextual.toString() + " - "
				+ creationalContext.toString());
		assertActive();

		Bean<T> bean = (Bean<T>) contextual;

		String variableName = bean.getName();
		System.out.println("getcontextual VAR NAME: " + variableName);
		String sid = getCallSid(bean);
		Object variable = null;
		if (sid != null) {
			variable = getTwilioManager().getVariable(sid);
		}
		if (variable != null) {
			System.out.println("getcontextual EXISTENT VALUE VAR: " + variable);
			describe(variable, "contestuale DA mappa: ");
			return (T) variable;
		} else {
			T beanInstance = bean.create(creationalContext);
			describe(beanInstance, "contestuale PER mappa: ");
			getTwilioManager().setVariable(getCallSid(beanInstance),
					beanInstance);
			System.out.println("getcontextual NEW VALUE VAR: " + beanInstance);
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
			System.out.println(e.getMessage());
		}
		return null;
	}

	private void describe(Object instance, String before) {
		try {
			TwilioScoped twScoped = (TwilioScoped) instance;
			if (twScoped != null && twScoped.getCallSid() != null) {
				System.out.println(before + "describe: " + twScoped);
				System.out.println(before + "describe: CALL SID "
						+ twScoped.getCallSid());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Class<? extends Annotation> getScope() {
		System.out.println("getScope TwilioScope.class");
		return TwilioScope.class;
	}

	@Override
	public boolean isActive() {
		System.out.println("isActive ");
		return true;
	}

	private void assertActive() {
		if (!isActive()) {
			throw new ContextNotActiveException(
					"Twilio context with scope annotation @TwilioScope is not active with respect to the current thread");
		}
	}

}
