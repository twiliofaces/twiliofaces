/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.twiliofaces.faces.component;

import static org.twiliofaces.faces.component.api.util.NounAttributes.action;
import static org.twiliofaces.faces.component.api.util.NounAttributes.finishOnKey;
import static org.twiliofaces.faces.component.api.util.NounAttributes.method;
import static org.twiliofaces.faces.component.api.util.NounAttributes.numDigits;
import static org.twiliofaces.faces.component.api.util.NounAttributes.timeout;
import static org.twiliofaces.faces.component.api.util.TagUtils.addAttribute;
import static org.twiliofaces.faces.component.api.util.TagUtils.end;
import static org.twiliofaces.faces.component.api.util.TagUtils.start;
import static org.twiliofaces.faces.component.api.util.Verbs.Gather;
import static org.twiliofaces.faces.component.api.util.Verbs.gather;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.faces.component.api.Component;

@FacesComponent(gather)
public class Gather extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Gather.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), finishOnKey.name());
		addAttribute(context, getAttributes(), numDigits.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, Gather.name());
	}

}