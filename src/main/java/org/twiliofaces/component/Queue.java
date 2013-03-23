package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.method;
import static org.twiliofaces.util.NounAttributes.url;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Queue;
import static org.twiliofaces.util.Verbs.queue;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(queue)
public class Queue extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Queue.name());
		addAttribute(context, getAttributes(), url.name());
		addAttribute(context, getAttributes(), method.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Queue.name());
	}

}