package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.action;
import static org.twiliofaces.util.NounAttributes.callerId;
import static org.twiliofaces.util.NounAttributes.hangupOnStar;
import static org.twiliofaces.util.NounAttributes.method;
import static org.twiliofaces.util.NounAttributes.record;
import static org.twiliofaces.util.NounAttributes.timeLimit;
import static org.twiliofaces.util.NounAttributes.timeout;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Dial;
import static org.twiliofaces.util.Verbs.dial;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(dial)
public class Dial extends Component {

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		start(context, Dial.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), timeout.name());
		addAttribute(context, getAttributes(), hangupOnStar.name());
		addAttribute(context, getAttributes(), timeLimit.name());
		addAttribute(context, getAttributes(), callerId.name());
		addAttribute(context, getAttributes(), record.name());
	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		addText(context, getAttributes(), value.name());
		end(context, Dial.name());
	}

}