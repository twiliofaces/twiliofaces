/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.component;

import static org.twiliofaces.component.api.util.TagUtils.addFacet;
import static org.twiliofaces.component.api.util.TagUtils.addSimpleText;
import static org.twiliofaces.component.api.util.TagUtils.addSingleAttribute;
import static org.twiliofaces.component.api.util.TagUtils.end;
import static org.twiliofaces.component.api.util.TagUtils.start;
import static org.twiliofaces.component.api.util.Verbs.jsClient;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(jsClient)
@ResourceDependencies({
		@ResourceDependency(name = "js/jquery/1.7.2/jquery.min.js", target = "head"),
		@ResourceDependency(name = "js/twiliojs/1.1/twilio.min.js", target = "head") })
public class JsClient extends Component {

	static String NEW_LINE = "\n";

	@Override
	public void encodeEnd(FacesContext context) throws IOException {
		start(context, "script");
		addSingleAttribute(context, "type", "text/javascript");
		setup(context);
		ready(context);
		offline(context);
		incoming(context);
		cancel(context);
		connect(context);
		disconnect(context);
		presence(context);
		error(context);
		javascript(context);
		end(context, "script");
	}

	public void setup(FacesContext context) throws IOException {
		// .setup( token, [params] )
		StringBuffer options = new StringBuffer();
		String token = (String) getAttributes().get("token");
		options.append("\"" + token + "\" ");
		// , {debug: true}
		boolean withParameters = false;
		String debug = (String) getAttributes().get("debug");
		if (debug != null && !debug.isEmpty() && "true".equals(debug)) {
			if (options.length() > 0)
				options.append(",");
			if (!withParameters)
				options.append(" {");
			options.append(" debug: true");
			withParameters = true;
		}
		// , {rtc: true}
		String rtc = (String) getAttributes().get("rtc");
		if (rtc != null && !rtc.isEmpty() && "true".equals(rtc)) {
			if (options.length() > 0)
				options.append(",");
			if (!withParameters)
				options.append(" {");
			options.append(" rtc: true");
			withParameters = true;
		}
		// , key1:value1,key2:value2
		String params = (String) getAttributes().get("params");
		if (params != null && !params.isEmpty() && "true".equals(params)) {
			if (options.length() > 0)
				options.append(",");
			if (!withParameters)
				options.append(" {");
			options.append(" " + params);
			withParameters = true;
		}
		if (withParameters)
			options.append(" } ");
		addSimpleText(context, NEW_LINE + "Twilio.Device.setup(" + NEW_LINE
				+ options.toString() + NEW_LINE + ");" + NEW_LINE);
	}

	public void ready(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.ready(function() {" + NEW_LINE);
		addFacet(context, this, "ready");
		// Could be called multiple times if network drops and comes back.
		// When the TOKEN allows incoming connections, this is called when
		// the incoming channel is open.
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void offline(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.offline(function() {" + NEW_LINE);
		addFacet(context, this, "offline");
		// Twilio.Device.offline(function() {
		// // Called on network connection lost.
		// });
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void incoming(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.incoming(function(conn) {"
				+ NEW_LINE);
		// Twilio.Device.incoming(function(conn) {
		// console.log(conn.parameters.From); // who is calling
		// conn.status // => "pending"
		// conn.accept();
		// conn.status // => "connecting"
		// });
		addFacet(context, this, "incoming");
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void cancel(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.cancel(function(conn) {"
				+ NEW_LINE);
		// Twilio.Device.cancel(function(conn) {
		// console.log(conn.parameters.From); // who canceled the call
		// conn.status // => "closed"
		// });
		addFacet(context, this, "cancel");
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void connect(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.connect(function (conn) {"
				+ NEW_LINE);
		// Twilio.Device.connect(function (conn) {
		// // Called for all new connections
		// console.log(conn.status);
		// });
		addFacet(context, this, "connect");
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void disconnect(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.disconnect(function (conn) {"
				+ NEW_LINE);
		// Twilio.Device.disconnect(function (conn) {
		// // Called for all disconnections
		// console.log(conn.status);
		// });
		addFacet(context, this, "disconnect");
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void presence(FacesContext context) throws IOException {
		addSimpleText(context,
				"Twilio.Device.presence(function (presenceEvent) {" + NEW_LINE);
		// Twilio.Device.presence(function (presenceEvent) {
		// // Called for each available client when this device becomes ready
		// // and every time another client's availability changes.
		// presenceEvent.from // => name of client whose availablity changed
		// presenceEvent.available // => true or false
		// });
		addFacet(context, this, "presence");
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void error(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.error(function (e) {" + NEW_LINE);
		// Twilio.Device.error(function (e) {
		// console.log(e.message + " for " + e.connection);
		// });
		addFacet(context, this, "error");
		addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
	}

	public void javascript(FacesContext context) throws IOException {
		addFacet(context, this, "javascript");
	}

}