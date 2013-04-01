/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.beep;
import static org.twiliofaces.util.NounAttributes.endConferenceOnExit;
import static org.twiliofaces.util.NounAttributes.maxParticipants;
import static org.twiliofaces.util.NounAttributes.muted;
import static org.twiliofaces.util.NounAttributes.startConferenceOnEnter;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.NounAttributes.waitMethod;
import static org.twiliofaces.util.NounAttributes.waitUrl;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Conference;
import static org.twiliofaces.util.Verbs.conference;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

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