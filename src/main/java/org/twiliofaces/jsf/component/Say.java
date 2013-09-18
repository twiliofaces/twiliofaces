/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.twiliofaces.jsf.component;

import static org.twiliofaces.jsf.component.api.util.NounAttributes.language;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.loop;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.value;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.voice;
import static org.twiliofaces.jsf.component.api.util.TagUtils.addAttribute;
import static org.twiliofaces.jsf.component.api.util.TagUtils.addText;
import static org.twiliofaces.jsf.component.api.util.TagUtils.end;
import static org.twiliofaces.jsf.component.api.util.TagUtils.start;
import static org.twiliofaces.jsf.component.api.util.Verbs.Say;
import static org.twiliofaces.jsf.component.api.util.Verbs.say;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.jsf.component.api.Component;

@FacesComponent(say)
public class Say extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Say.name());
		addAttribute(context, getAttributes(), voice.name());
		addAttribute(context, getAttributes(), language.name());
		addAttribute(context, getAttributes(), loop.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Say.name());
	}

}