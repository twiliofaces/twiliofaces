package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.loop;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Play;
import static org.twiliofaces.util.Verbs.play;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(play)
public class Play extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Play.name());
		addAttribute(context, getAttributes(), loop.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Play.name());
	}

}