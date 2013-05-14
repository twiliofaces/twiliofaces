/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ package org.twiliofaces.component;

import static org.twiliofaces.component.api.util.NounAttributes.reason;
import static org.twiliofaces.component.api.util.TagUtils.addAttribute;
import static org.twiliofaces.component.api.util.TagUtils.end;
import static org.twiliofaces.component.api.util.TagUtils.start;
import static org.twiliofaces.component.api.util.Verbs.Reject;
import static org.twiliofaces.component.api.util.Verbs.reject;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(reject)
public class Reject extends Component {

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, Reject.name());
		addAttribute(context, getAttributes(), reason.name());
		end(context, Reject.name());
	}

}