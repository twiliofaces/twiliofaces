package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.reason;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Reject;
import static org.twiliofaces.util.Verbs.reject;

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