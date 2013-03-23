/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.component;

import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Hangup;
import static org.twiliofaces.util.Verbs.hangup;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(hangup)
public class Hangup extends Component {

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, Hangup.name());
		end(context, Hangup.name());
	}

}