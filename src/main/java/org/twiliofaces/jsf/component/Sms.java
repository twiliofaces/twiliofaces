/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.jsf.component;

import static org.twiliofaces.jsf.component.api.util.NounAttributes.action;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.from;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.method;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.statusCallBack;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.to;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.value;
import static org.twiliofaces.jsf.component.api.util.TagUtils.addAttribute;
import static org.twiliofaces.jsf.component.api.util.TagUtils.addText;
import static org.twiliofaces.jsf.component.api.util.TagUtils.end;
import static org.twiliofaces.jsf.component.api.util.TagUtils.start;
import static org.twiliofaces.jsf.component.api.util.Verbs.Sms;
import static org.twiliofaces.jsf.component.api.util.Verbs.sms;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.jsf.component.api.Component;

@FacesComponent(sms)
public class Sms extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Sms.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), to.name());
		addAttribute(context, getAttributes(), from.name());
		addAttribute(context, getAttributes(), statusCallBack.name());
		addText(context, getAttributes(), value.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, Sms.name());
	}

}