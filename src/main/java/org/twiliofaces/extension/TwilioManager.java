/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.extension;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.twiliofaces.api.event.StatusCallbackEvent;

@ApplicationScoped
public class TwilioManager implements Serializable {

	private static final long serialVersionUID = 1L;
	TwilioScopedMap twilioScopedMap;

	public TwilioManager() {
	}

	public void processEvent(@Observes StatusCallbackEvent event) {
		// System.out.println(getTwilioScopedMap().getAll().size());
		if (event instanceof StatusCallbackEvent) {
			getTwilioScopedMap().remove(event.getCallSid());
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getVariable(String variableName) {
		Object value = null;
		if (getTwilioScopedMap().holdsValue(variableName)) {
			value = getTwilioScopedMap().getContextualInstance(variableName);
			return (T) value;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T getOrCreate(String callSid, Object instance) {
		Object value = null;
		if (getTwilioScopedMap().holdsValue(callSid)) {
			// System.out.println("EXISTENT SID:" + callSid);
			value = getTwilioScopedMap().getContextualInstance(callSid);
			return (T) value;
		} else {
			// System.out.println("CREATED SID:" + callSid);
			getTwilioScopedMap().put(callSid, instance);
			return (T) instance;
		}
	}

	public void setVariable(String variableName, Object value) {
		getTwilioScopedMap().put(variableName, value);
	}

	public TwilioScopedMap getTwilioScopedMap() {
		if (twilioScopedMap == null)
			this.twilioScopedMap = new TwilioScopedMap();
		return twilioScopedMap;
	}

	public void setBeanStore(TwilioScopedMap beanStore) {
		this.twilioScopedMap = beanStore;
	}
}