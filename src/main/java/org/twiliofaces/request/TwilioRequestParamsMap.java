package org.twiliofaces.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TwilioRequestParamsMap implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> values;

	public Map<String, String> getValues() {
		if (this.values == null)
			this.values = new HashMap<String, String>();
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	public void setValue(String key, String value) {
		getValues().put(key, value);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (String key : getValues().keySet()) {
			if (key != null && !key.isEmpty())
				buffer.append(key + ": " + getValues().get(key) + "\n");
		}
		return buffer.toString();
	}
}
