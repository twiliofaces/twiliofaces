/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.component;

import static org.twiliofaces.util.TagUtils.addSimpleText;
import static org.twiliofaces.util.TagUtils.addSingleAttribute;
import static org.twiliofaces.util.TagUtils.end;
import static org.twiliofaces.util.TagUtils.start;
import static org.twiliofaces.util.Verbs.jsClient;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.component.api.Component;

@FacesComponent(jsClient)
@ResourceDependencies({
		@ResourceDependency(name = "https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js", target = "head"),
		@ResourceDependency(name = "http://static.twilio.com/libs/twiliojs/1.1/twilio.min.js", target = "head") })
public class JsClient extends Component {

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
		end(context, "script");
	}

	public void setup(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.setup(\"\")");
	}

	public void ready(FacesContext context) throws IOException {
		addSimpleText(context, "Twilio.Device.ready(function() {");
		UIComponent ready = getFacet("ready");
		ready.getChildren();

		//
		// Could be called multiple times if network drops and comes back.
		// When the TOKEN allows incoming connections, this is called when
		// the incoming channel is open.
		addSimpleText(context, " });");
	}

	public void offline(FacesContext context) throws IOException {

		// Twilio.Device.offline(function() {
		// // Called on network connection lost.
		// });
	}

	public void incoming(FacesContext context) throws IOException {
		// Twilio.Device.incoming(function(conn) {
		// console.log(conn.parameters.From); // who is calling
		// conn.status // => "pending"
		// conn.accept();
		// conn.status // => "connecting"
		// });
	}

	public void cancel(FacesContext context) throws IOException {
		// Twilio.Device.cancel(function(conn) {
		// console.log(conn.parameters.From); // who canceled the call
		// conn.status // => "closed"
		// });
	}

	public void connect(FacesContext context) throws IOException {
		// Twilio.Device.connect(function (conn) {
		// // Called for all new connections
		// console.log(conn.status);
		// });
	}

	public void disconnect(FacesContext context) throws IOException {
		// Twilio.Device.disconnect(function (conn) {
		// // Called for all disconnections
		// console.log(conn.status);
		// });
	}

	public void presence(FacesContext context) throws IOException {
		// Twilio.Device.presence(function (presenceEvent) {
		// // Called for each available client when this device becomes ready
		// // and every time another client's availability changes.
		// presenceEvent.from // => name of client whose availablity changed
		// presenceEvent.available // => true or false
		// });
	}

	public void error(FacesContext context) throws IOException {
		// Twilio.Device.error(function (e) {
		// console.log(e.message + " for " + e.connection);
		// });
	}

}