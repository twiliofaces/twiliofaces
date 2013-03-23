package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.length;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Pause;
import static org.twiliofaces.util.Verbs.pause;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(pause)
public class Pause extends Component {

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, Pause.name());
		addAttribute(context, getAttributes(), length.name());
		end(context, Pause.name());
	}

}