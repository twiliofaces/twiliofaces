package org.twiliofaces.component.api;

import static org.twiliofaces.util.Constants.FAMILY;
import static org.twiliofaces.util.Constants.RENDER_TYPE;

import javax.faces.component.UIOutput;

public class Component extends UIOutput {

	@Override
	public String getFamily() {
		return FAMILY;
	}

	@Override
	public String getRendererType() {
		return RENDER_TYPE;
	}

}
