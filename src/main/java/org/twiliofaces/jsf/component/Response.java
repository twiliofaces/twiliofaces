/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.jsf.component;

import static org.twiliofaces.jsf.component.api.util.TagUtils.end;
import static org.twiliofaces.jsf.component.api.util.TagUtils.start;
import static org.twiliofaces.jsf.component.api.util.Verbs.Response;
import static org.twiliofaces.jsf.component.api.util.Verbs.response;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.jsf.component.api.Component;

@FacesComponent(response)
public class Response extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Response.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, Response.name());
	}

}