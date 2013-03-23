package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.action;
import static org.twiliofaces.util.NounAttributes.method;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.NounAttributes.waitUrl;
import static org.twiliofaces.util.NounAttributes.waitUrlMethod;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Enqueue;
import static org.twiliofaces.util.Verbs.enqueue;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(enqueue)
public class Enqueue extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Enqueue.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), waitUrl.name());
		addAttribute(context, getAttributes(), waitUrlMethod.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Enqueue.name());
	}

}