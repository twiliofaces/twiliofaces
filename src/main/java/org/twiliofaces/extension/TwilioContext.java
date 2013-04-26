package org.twiliofaces.extension;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.twiliofaces.annotations.TwilioScope;
import org.twiliofaces.event.StatusCallbackEvent;

public class TwilioContext implements Context {

	private final static String COMPONENT_MAP_NAME = "org.twiliofaces.extension.twilioscope.componentInstanceMap";
	private final static String CREATIONAL_MAP_NAME = "org.twiliofaces.extension.twilioscope.creationalInstanceMap";

	@SuppressWarnings("unchecked")
	public <T> T get(final Contextual<T> component) {
		assertActive();
		T instance = (T) getComponentInstanceMap().get(component);
		if (instance instanceof TwilioScoped) {
			TwilioScoped twScoped = (TwilioScoped) instance;
			if (twScoped != null)
				System.out.println(twScoped.getCallSid());
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(final Contextual<T> component,
			final CreationalContext<T> creationalContext) {
		assertActive();

		T instance = get(component);
		if (instance == null && instance instanceof TwilioScoped) {
			if (creationalContext != null) {
				Map<Contextual<?>, Object> componentInstanceMap = getComponentInstanceMap();
				Map<Contextual<?>, CreationalContext<?>> creationalContextMap = getCreationalInstanceMap();

				synchronized (componentInstanceMap) {
					instance = (T) componentInstanceMap.get(component);
					if (instance == null) {
						instance = component.create(creationalContext);
						if (instance != null) {
							componentInstanceMap.put(component, instance);
							creationalContextMap.put(component,
									creationalContext);
						}
					}
				}
			}
		}

		return instance;
	}

	@Override
	public Class<? extends Annotation> getScope() {
		return TwilioScope.class;
	}

	@Override
	public boolean isActive() {
		return getViewRoot() != null;
	}

	@SuppressWarnings("unchecked")
	private Map<Contextual<?>, Object> getComponentInstanceMap() {
		Map<String, Object> viewMap = getViewMap();
		Map<Contextual<?>, Object> map = (ConcurrentHashMap<Contextual<?>, Object>) viewMap
				.get(COMPONENT_MAP_NAME);

		if (map == null) {
			map = new ConcurrentHashMap<Contextual<?>, Object>();
			viewMap.put(COMPONENT_MAP_NAME, map);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	private Map<Contextual<?>, CreationalContext<?>> getCreationalInstanceMap() {
		Map<String, Object> viewMap = getViewMap();
		Map<Contextual<?>, CreationalContext<?>> map = (Map<Contextual<?>, CreationalContext<?>>) viewMap
				.get(CREATIONAL_MAP_NAME);

		if (map == null) {
			map = new ConcurrentHashMap<Contextual<?>, CreationalContext<?>>();
			viewMap.put(CREATIONAL_MAP_NAME, map);
		}

		return map;
	}

	/*
	 * TODO: COME RIAGGANCIO LA SINGOLA ISTANZA DA DISTRUGGERE? DATO IL SID!!!
	 */
	@SuppressWarnings("unchecked")
	public void processEvent(@Observes StatusCallbackEvent event) {
		if (event instanceof StatusCallbackEvent) {
			Map<Contextual<?>, Object> componentInstanceMap = getComponentInstanceMap();
			Map<Contextual<?>, CreationalContext<?>> creationalContextMap = getCreationalInstanceMap();

			if (componentInstanceMap != null) {
				for (Entry<Contextual<?>, Object> componentEntry : componentInstanceMap
						.entrySet()) {
					Contextual contextual = componentEntry.getKey();
					Object instance = componentEntry.getValue();
					if (instance instanceof TwilioScoped) {
						TwilioScoped twScoped = (TwilioScoped) instance;
						if (twScoped.getCallSid() != null
								&& twScoped.getCallSid().equals(
										event.getCallSid())) {
							CreationalContext creational = creationalContextMap
									.get(contextual);

							contextual.destroy(instance, creational);
						}
					}

				}
			}
		}
	}

	private void assertActive() {
		if (!isActive()) {
			throw new ContextNotActiveException(
					"Twilio context with scope annotation @TwilioScope is not active with respect to the current thread");
		}
	}

	public boolean isListenerForSource(final Object source) {
		if (source instanceof UIViewRoot) {
			return true;
		}

		return false;
	}

	protected UIViewRoot getViewRoot() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context != null) {
			return context.getViewRoot();
		}

		return null;
	}

	protected Map<String, Object> getViewMap() {
		UIViewRoot viewRoot = getViewRoot();

		if (viewRoot != null) {
			return viewRoot.getViewMap(true);
		}

		return null;
	}

}
