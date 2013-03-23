package org.twiliofaces.component;

import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Response;
import static org.twiliofaces.util.Verbs.response;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(response)
public class Response extends Component {

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, Response.name());
		end(context, Response.name());
	}

}