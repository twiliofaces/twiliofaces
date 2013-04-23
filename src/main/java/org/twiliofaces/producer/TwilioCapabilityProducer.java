package org.twiliofaces.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.annotations.configuration.ApplicationSid;
import org.twiliofaces.annotations.configuration.TwilioClientToken;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;

import com.twilio.sdk.client.TwilioCapability;
import com.twilio.sdk.client.TwilioCapability.DomainException;

public class TwilioCapabilityProducer {

	@Inject
	FacesContext facesContext;

	@TwilioSid
	String twilioSid;

	@TwilioToken
	String twilioToken;

	@ApplicationSid
	String applicationSid;

	@Produces
	@TwilioClientToken
	public String getTwilioClientToken(InjectionPoint injectionPoint) {
		TwilioCapability capability = new TwilioCapability(twilioSid,
				twilioToken);
		if (applicationSid != null && !applicationSid.isEmpty())
			capability.allowClientOutgoing(applicationSid);
		String client = injectionPoint.getAnnotated()
				.getAnnotation(TwilioClientToken.class).client();
		capability.allowClientIncoming(client);

		try {
			return capability.generateToken();
		} catch (DomainException e) {
			e.printStackTrace();
		}
		return null;
	}
}
