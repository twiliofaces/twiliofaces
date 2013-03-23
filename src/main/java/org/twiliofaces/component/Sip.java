/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.method;
import static org.twiliofaces.util.NounAttributes.password;
import static org.twiliofaces.util.NounAttributes.url;
import static org.twiliofaces.util.NounAttributes.username;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Sip;
import static org.twiliofaces.util.Verbs.sip;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(sip)
public class Sip extends Component {

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, Sip.name());
		addAttribute(context, getAttributes(), url.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), username.name());
		addAttribute(context, getAttributes(), password.name());
		addText(context, getAttributes(), value.name());
		end(context, Sip.name());
	}

}