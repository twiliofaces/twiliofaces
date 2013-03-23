/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.method;
import static org.twiliofaces.util.NounAttributes.url;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Client;
import static org.twiliofaces.util.Verbs.client;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(client)
public class Client extends Component {

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, Client.name());
		addAttribute(context, getAttributes(), url.name());
		addAttribute(context, getAttributes(), method.name());
		addText(context, getAttributes(), value.name());
		end(context, Client.name());
	}

}