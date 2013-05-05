package org.twiliofaces.extension;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TwilioScopedMap implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> beanStore = new ConcurrentHashMap<String, Object>();

	public synchronized void put(String name, Object instance) {
		System.out.println("put: " + name);
		beanStore.put(name, instance);
	}

	public Object getContextualInstance(String name) {
//		System.out.println("get: " + name);
		return beanStore.get(name);
	}

	public Set<String> getVariableNames() {
		return beanStore.keySet();
	}

	public synchronized void putAll(Map<String, Object> variables) {
		beanStore.putAll(variables);
	}

	public Map<String, Object> getAll() {
		return beanStore;
	}

	public synchronized void clear() {
		beanStore.clear();
	}

	public boolean holdsValue(String name) {
		return beanStore.containsKey(name);
	}

	public synchronized void remove(String name) {
		if (beanStore.containsKey(name)) {
			System.out.println("remove: " + name);
			beanStore.remove(name);
		}
	}

	public synchronized Map<String, Object> getAllAndClear() {
		HashMap<String, Object> hashMap = new HashMap<String, Object>(beanStore);
		beanStore.clear();
		return hashMap;
	}

}
