/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.twiliofaces.component;

import static org.twiliofaces.component.api.util.NounAttributes.action;
import static org.twiliofaces.component.api.util.NounAttributes.method;
import static org.twiliofaces.component.api.util.NounAttributes.value;
import static org.twiliofaces.component.api.util.NounAttributes.waitUrl;
import static org.twiliofaces.component.api.util.NounAttributes.waitUrlMethod;
import static org.twiliofaces.component.api.util.TagUtils.addAttribute;
import static org.twiliofaces.component.api.util.TagUtils.addText;
import static org.twiliofaces.component.api.util.TagUtils.end;
import static org.twiliofaces.component.api.util.TagUtils.start;
import static org.twiliofaces.component.api.util.Verbs.Enqueue;
import static org.twiliofaces.component.api.util.Verbs.enqueue;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(enqueue)
public class Enqueue extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Enqueue.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), waitUrl.name());
		addAttribute(context, getAttributes(), waitUrlMethod.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Enqueue.name());
	}

}