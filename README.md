Twiliofaces - how use  [twilio](http://www.twilio.com) services with Java EE 6 Technologies (jsf, cdi)
=============================


This is a jsf library written to use twilio on jee6. This library produces TwiML (the [Twilio Markup Language](http://www.twilio.com/docs/api/twiml) ) in a simple way: using jsf tags. 
This library is designed to be used in [Openshift](https://www.openshift.com) [JBoss AS 7 server] (http://www.jboss.org/jbossas).

Usage
-----
An exemplary usage of the client may look like the following:

on xhtml page
```xml
<?xml version="1.0" encoding="UTF-8"?>
<f:view xmlns="http://www.w3c.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:tf="http://twiliofaces.org/twiliofaces">
	<f:event type="preRenderView"
		listener="#{requestController.init}" />
	<tf:response>
		<tf:say>Hello!</ff:say>
		<tf:dial>
			<ff:number value="+393922274929" />
		</tf:dial>
	</tf:response>
</f:view>
```

Download 
--------
You may either build from source using maven (mvn clean package) or (in the future) get the prebuilt artifact from the maven central.