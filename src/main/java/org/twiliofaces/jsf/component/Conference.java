/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.jsf.component;

import static org.twiliofaces.jsf.component.api.util.NounAttributes.beep;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.endConferenceOnExit;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.maxParticipants;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.muted;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.startConferenceOnEnter;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.value;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.waitMethod;
import static org.twiliofaces.jsf.component.api.util.NounAttributes.waitUrl;
import static org.twiliofaces.jsf.component.api.util.TagUtils.addAttribute;
import static org.twiliofaces.jsf.component.api.util.TagUtils.addText;
import static org.twiliofaces.jsf.component.api.util.TagUtils.end;
import static org.twiliofaces.jsf.component.api.util.TagUtils.start;
import static org.twiliofaces.jsf.component.api.util.Verbs.Conference;
import static org.twiliofaces.jsf.component.api.util.Verbs.conference;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.jsf.component.api.Component;

@FacesComponent(conference)
public class Conference extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Conference.name());
		addAttribute(context, getAttributes(), muted.name());
		addAttribute(context, getAttributes(), beep.name());
		addAttribute(context, getAttributes(), startConferenceOnEnter.name());
		addAttribute(context, getAttributes(), endConferenceOnExit.name());
		addAttribute(context, getAttributes(), waitUrl.name());
		addAttribute(context, getAttributes(), waitMethod.name());
		addAttribute(context, getAttributes(), maxParticipants.name());
		addText(context, getAttributes(), value.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, Conference.name());
	}
}