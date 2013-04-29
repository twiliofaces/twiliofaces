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
		return null;
		// Bean<T> bean = (Bean<T>) contextual;
		// String variableName = bean.getName();
		// describe(bean, "FIND SIMPLE SID: ");
		// System.out.println("get VAR NAME: " + variableName);
		// Object variable = getTwilioManager().getVariable(variableName);
		// if (variable != null) {
		// describe(variable, "FOUND SIMPLE ");
		// return (T) variable;
		// } else {
		// return null;
		// }
	}

	@SuppressWarnings({ "unchecked" })
	public <T> T get(final Contextual<T> contextual,
			final CreationalContext<T> creationalContext) {
		System.out.println("getcontextual: " + contextual.toString() + " - "
				+ creationalContext.toString());
		assertActive();

		Bean<T> bean = (Bean<T>) contextual;
		// VEDIAMO
		T beanInstance = bean.create(creationalContext);
		describe(beanInstance, "CREATE TEMPORAL CONTESTUAL: ");
		String callSid = getCallSid(beanInstance);
		T toReturn = getTwilioManager().getOrCreate(callSid, beanInstance);
		describe(toReturn, "REAL CONTESTUAL: ");
		if (!toReturn.equals(beanInstance)) {
			System.out.println("REMOVE TEMPORAL!!!");
			contextual.destroy(beanInstance, creationalContext);
		}
		return toReturn;
		// describe(bean, "FIND CONTEXTUAL SID: ");
		//
		// String variableName = bean.getName();
		// System.out.println("FIND: " + variableName);
		// Object variable = getTwilioManager().getVariable(variableName);
		//
		// if (variable != null) {
		// describe(variable, "FOUND CONTESTUAL: ");
		// return (T) variable;
		// } else {
		// T beanInstance = bean.create(creationalContext);
		// describe(beanInstance, "CREATE CONTESTUAL: ");
		// getTwilioManager().setVariable(bean.getName(), beanInstance);
		// return beanInstance;
		// }

	}

	private TwilioManager getTwilioManager() {
		Bean phBean = (Bean) beanManager.getBeans(TwilioManager.class)
				.iterator().next();
		CreationalContext cc = beanManager.createCreationalContext(phBean);
		TwilioManager bean = (TwilioManager) beanManager.getReference(phBean,
				TwilioManager.class, cc);
		return bean;
	}

	private String getCallSid(Object instance) {
		try {
			if (TwilioScoped.class.isAssignableFrom(instance.getClass())) {
				TwilioScoped twScoped = (TwilioScoped) instance;
				if (twScoped != null && twScoped.getCallSid() != null) {
					return twScoped.getCallSid();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void describe(Object instance, String before) {
		try {
			if (TwilioScoped.class.isAssignableFrom(instance.getClass())) {
				TwilioScoped twScoped = (TwilioScoped) instance;
				if (twScoped != null && twScoped.getCallSid() != null) {
					System.out.println(before + ": " + twScoped
							+ " - CALL SID: " + twScoped.getCallSid());
				}
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
