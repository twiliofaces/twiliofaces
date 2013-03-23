package org.twiliofaces.component;

import static org.twiliofaces.util.NounAttributes.action;
import static org.twiliofaces.util.NounAttributes.from;
import static org.twiliofaces.util.NounAttributes.method;
import static org.twiliofaces.util.NounAttributes.statusCallBack;
import static org.twiliofaces.util.NounAttributes.to;
import static org.twiliofaces.util.NounAttributes.value;
import static org.twiliofaces.util.TagUtils.addAttribute;
import static org.twiliofaces.util.TagUtils.addText;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.Sms;
import static org.twiliofaces.util.Verbs.sms;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(sms)
public class Sms extends Component {

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, Sms.name());
		addAttribute(context, getAttributes(), action.name());
		addAttribute(context, getAttributes(), method.name());
		addAttribute(context, getAttributes(), to.name());
		addAttribute(context, getAttributes(), from.name());
		addAttribute(context, getAttributes(), statusCallBack.name());
		addText(context, getAttributes(), value.name());
		end(context, Sms.name());
	}

}