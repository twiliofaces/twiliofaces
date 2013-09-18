/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ package org.twiliofaces.jsf.component;

import static org.twiliofaces.jsf.component.api.util.NounAttributes.length;
import static org.twiliofaces.jsf.component.api.util.TagUtils.addAttribute;
import static org.twiliofaces.jsf.component.api.util.TagUtils.end;
import static org.twiliofaces.jsf.component.api.util.TagUtils.start;
import static org.twiliofaces.jsf.component.api.util.Verbs.Pause;
import static org.twiliofaces.jsf.component.api.util.Verbs.pause;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.jsf.component.api.Component;

@FacesComponent(pause)
public class Pause extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Pause.name());
		addAttribute(context, getAttributes(), length.name());
		end(context, Pause.name());
	}

}