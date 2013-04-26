package org.twiliofaces.producer;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.application.Application;
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

	@TwilioClientToken(client = "#{params.name}")
	String flowerToken;

	@Produces
	@TwilioClientToken(client = "")
	public String getTwilioClientToken(InjectionPoint injectionPoint) {
		Application app = facesContext.getApplication();
		facesContext.getViewRoot();
		ExpressionFactory exprFactory = app.getExpressionFactory();
		ELContext elContext = facesContext.getELContext();
		// creating value expression with the help of the expression factory and
		// the ELContext
		ValueExpression valExpr = exprFactory.createValueExpression(elContext,
				"#{params.name}", Object.class);
		Boolean developmentMode = (Boolean) valExpr.getValue(elContext);
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
