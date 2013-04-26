package org.twiliofaces.extension;

import java.io.Serializable;
import java.util.Date;
import java.util.Map.Entry;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.twiliofaces.event.StatusCallbackEvent;

@ApplicationScoped
public class TwilioManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CachingBeanStore beanStore;

	public TwilioManager() {
		System.out.println("TwilioManager" + new Date());
	}

	/*
	 * TODO: COME RIAGGANCIO LA SINGOLA ISTANZA DA DISTRUGGERE? DATO IL SID!!!
	 */
	public void processEvent(@Observes StatusCallbackEvent event) {
		System.out.println("processEvent: " + event.toString());

		if (event instanceof StatusCallbackEvent) {
			System.out.println("processEvent bean store size: "
					+ getBeanStore().getAll().size());
			for (Entry<String, Object> componentEntry : getBeanStore().getAll()
					.entrySet()) {
				System.out.println("processEvent: FOR CYCLE KEY"
						+ componentEntry.getKey());
				Object instance = componentEntry.getValue();
				System.out.println("processEvent: FOR CYCLE VALUE" + instance);
				try {
					TwilioScoped twScoped = (TwilioScoped) instance;
					if (twScoped.getCallSid() != null
							&& twScoped.getCallSid().equals(event.getCallSid())) {
						System.out.println("processEvent: FOUND " + twScoped);
						System.out.println("processEvent: CALL SID "
								+ twScoped.getCallSid());
						getBeanStore().remove(componentEntry.getKey());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getVariable(String variableName) {
		Object value = null;
		if (getBeanStore().holdsValue(variableName)) {
			value = getBeanStore().getContextualInstance(variableName);
		} else {
			// cache the value in the bean store.
			getBeanStore().put(variableName, value);
		}
		setVariable(variableName, value);
		if (value == null) {
			return null;
		} else {
			return (T) value;
		}
	}

	public void setVariable(String variableName, Object value) {
		getBeanStore().put(variableName, value);
	}

	public CachingBeanStore getBeanStore() {
		if (beanStore == null)
			this.beanStore = new CachingBeanStore();
		return beanStore;
	}

	public void setBeanStore(CachingBeanStore beanStore) {
		this.beanStore = beanStore;
	}

}
