/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.jsf.component;

import static org.twiliofaces.jsf.component.api.util.TagUtils.end;
import static org.twiliofaces.jsf.component.api.util.TagUtils.start;
import static org.twiliofaces.jsf.component.api.util.Verbs.Hangup;
import static org.twiliofaces.jsf.component.api.util.Verbs.hangup;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.jsf.component.api.Component;

@FacesComponent(hangup)
public class Hangup extends Component {

	@Override
	public void encodeAll(FacesContext context) throws IOException {
		start(context, Hangup.name());
		end(context, Hangup.name());
	}

}