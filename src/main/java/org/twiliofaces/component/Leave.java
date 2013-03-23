package org.twiliofaces.component;

import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Leave;
import static org.twiliofaces.util.Verbs.leave;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(leave)
public class Leave extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Leave.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		end(context, Leave.name());
	}

}