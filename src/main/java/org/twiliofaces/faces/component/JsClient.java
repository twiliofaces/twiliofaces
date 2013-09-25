/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.twiliofaces.faces.component;

import static org.twiliofaces.faces.component.api.util.JsConstants.CANCEL;
import static org.twiliofaces.faces.component.api.util.JsConstants.CONNECT;
import static org.twiliofaces.faces.component.api.util.JsConstants.DEBUG;
import static org.twiliofaces.faces.component.api.util.JsConstants.DISCONNECT;
import static org.twiliofaces.faces.component.api.util.JsConstants.ERROR;
import static org.twiliofaces.faces.component.api.util.JsConstants.FALSE;
import static org.twiliofaces.faces.component.api.util.JsConstants.INCOMING;
import static org.twiliofaces.faces.component.api.util.JsConstants.JAVASCRIPT;
import static org.twiliofaces.faces.component.api.util.JsConstants.JQUERY_JS_1_6_2;
import static org.twiliofaces.faces.component.api.util.JsConstants.NEW_LINE;
import static org.twiliofaces.faces.component.api.util.JsConstants.OFFLINE;
import static org.twiliofaces.faces.component.api.util.JsConstants.PARAMS;
import static org.twiliofaces.faces.component.api.util.JsConstants.PRESENCE;
import static org.twiliofaces.faces.component.api.util.JsConstants.READY;
import static org.twiliofaces.faces.component.api.util.JsConstants.RTC;
import static org.twiliofaces.faces.component.api.util.JsConstants.SCRIPT;
import static org.twiliofaces.faces.component.api.util.JsConstants.TEXT_JAVASCRIPT;
import static org.twiliofaces.faces.component.api.util.JsConstants.TOKEN;
import static org.twiliofaces.faces.component.api.util.JsConstants.TRUE;
import static org.twiliofaces.faces.component.api.util.JsConstants.TWILIO_JS_1_1;
import static org.twiliofaces.faces.component.api.util.JsConstants.TYPE;
import static org.twiliofaces.faces.component.api.util.JsConstants.WITHOUT_JS;
import static org.twiliofaces.faces.component.api.util.TagUtils.addFacet;
import static org.twiliofaces.faces.component.api.util.TagUtils.addSimpleText;
import static org.twiliofaces.faces.component.api.util.TagUtils.addSingleAttribute;
import static org.twiliofaces.faces.component.api.util.TagUtils.addUIOutput;
import static org.twiliofaces.faces.component.api.util.TagUtils.end;
import static org.twiliofaces.faces.component.api.util.TagUtils.start;
import static org.twiliofaces.faces.component.api.util.Verbs.jsClient;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;

import org.twiliofaces.faces.component.api.Component;

@FacesComponent(jsClient)
public class JsClient extends Component
{

   @Override
   public void encodeAll(FacesContext context) throws IOException
   {
      String withoutJs = (String) getAttributes().get(WITHOUT_JS);
      if (withoutJs == null || withoutJs.isEmpty() || FALSE.equals(withoutJs))
      {
         addUIOutput(context, TWILIO_JS_1_1);
         addSimpleText(context, "" + NEW_LINE);
         addUIOutput(context, JQUERY_JS_1_6_2);
         addSimpleText(context, "" + NEW_LINE);
      }
      addSimpleText(context, NEW_LINE);
      start(context, SCRIPT);
      addSingleAttribute(context, TYPE, TEXT_JAVASCRIPT);
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
      end(context, SCRIPT);
      addSimpleText(context, NEW_LINE);
   }

   public void setup(FacesContext context) throws IOException
   {
      // .setup( token, [params] )
      StringBuffer options = new StringBuffer();
      String token = (String) getAttributes().get(TOKEN);
      options.append("\"" + token + "\" ");
      // , {debug: true}
      boolean withParameters = false;
      String debug = (String) getAttributes().get(DEBUG);
      if (debug != null && !debug.isEmpty() && TRUE.equals(debug))
      {
         if (options.length() > 0)
            options.append(",");
         if (!withParameters)
            options.append(" {");
         options.append(" debug: true");
         withParameters = true;
      }
      // , {rtc: true}
      String rtc = (String) getAttributes().get(RTC);
      if (rtc != null && !rtc.isEmpty() && TRUE.equals(rtc))
      {
         if (options.length() > 0)
            options.append(",");
         if (!withParameters)
            options.append(" {");
         options.append(" rtc: true");
         withParameters = true;
      }
      // , key1:value1,key2:value2
      String params = (String) getAttributes().get(PARAMS);
      if (params != null && !params.isEmpty() && TRUE.equals(params))
      {
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

   public void ready(FacesContext context) throws IOException
   {
      addSimpleText(context, "Twilio.Device.ready(function() {" + NEW_LINE);
      addFacet(context, this, READY);
      // Could be called multiple times if network drops and comes back.
      // When the TOKEN allows incoming connections, this is called when
      // the incoming channel is open.
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void offline(FacesContext context) throws IOException
   {
      addSimpleText(context, "Twilio.Device.offline(function() {" + NEW_LINE);
      addFacet(context, this, OFFLINE);
      // Twilio.Device.offline(function() {
      // // Called on network connection lost.
      // });
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void incoming(FacesContext context) throws IOException
   {
      addSimpleText(context, "Twilio.Device.incoming(function(incoming) {"
               + NEW_LINE);
      // Twilio.Device.incoming(function(incoming) {
      // console.log(conn.parameters.From); // who is calling
      // incoming.status // => "pending"
      // incoming.accept();
      // incoming.status // => "connecting"
      // });
      addFacet(context, this, INCOMING);
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void cancel(FacesContext context) throws IOException
   {
      addSimpleText(context, "Twilio.Device.cancel(function(cancel) {"
               + NEW_LINE);
      // Twilio.Device.cancel(function(cancel) {
      // console.log(cancel.parameters.From); // who canceled the call
      // cancel.status // => "closed"
      // });
      addFacet(context, this, CANCEL);
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void connect(FacesContext context) throws IOException
   {
      addSimpleText(context, "Twilio.Device.connect(function (connect) {"
               + NEW_LINE);
      // Twilio.Device.connect(function (connect) {
      // // Called for all new connections
      // console.log(connect.status);
      // });
      addFacet(context, this, CONNECT);
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void disconnect(FacesContext context) throws IOException
   {
      addSimpleText(context, "Twilio.Device.disconnect(function (disconnect) {"
               + NEW_LINE);
      // Twilio.Device.disconnect(function (disconnect) {
      // // Called for all disconnections
      // console.log(disconnect.status);
      // });
      addFacet(context, this, DISCONNECT);
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void presence(FacesContext context) throws IOException
   {
      addSimpleText(context,
               "Twilio.Device.presence(function (presence) {" + NEW_LINE);
      // Twilio.Device.presence(function (presence) {
      // // Called for each available client when this device becomes ready
      // // and every time another client's availability changes.
      // presence.from // => name of client whose availablity changed
      // presence.available // => true or false
      // });
      addFacet(context, this, PRESENCE);
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void error(FacesContext context) throws IOException
   {
      addSimpleText(context, "Twilio.Device.error(function (error) {" + NEW_LINE);
      // Twilio.Device.error(function (error) {
      // console.log(error.message + " for " + error.connection);
      // });
      addFacet(context, this, ERROR);
      addSimpleText(context, NEW_LINE + " });" + NEW_LINE);
   }

   public void javascript(FacesContext context) throws IOException
   {
      addFacet(context, this, JAVASCRIPT);
   }

}