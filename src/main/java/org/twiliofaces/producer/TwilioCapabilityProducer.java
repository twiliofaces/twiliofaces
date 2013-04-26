package org.twiliofaces.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.twiliofaces.annotations.configuration.ApplicationSid;
import org.twiliofaces.annotations.configuration.TwilioClientToken;
import org.twiliofaces.annotations.configuration.TwilioSid;
import org.twiliofaces.annotations.configuration.TwilioToken;

public class TwilioCapabilityProducer {

	@Inject
	FacesContext facesContext;

	@TwilioSid
	String twilioSid;

	@TwilioToken
	String twilioToken;

	@ApplicationSid
	String applicationSid;

	// @TwilioClientToken(client = "#{params.name}")
	// String flowerToken;

	@Produces
	@TwilioClientToken
	public String getTwilioClientToken(InjectionPoint injectionPoint) {
		Application app = facesContext.getApplication();
		facesContext.getViewRoot();
		// ExpressionFactory exprFactory = app.getExpressionFactory();
		// ELContext elContext = facesContext.getELContext();
		//
		// ValueExpression valExpr =
		// exprFactory.createValueExpression(elContext,
		// "#{params.name}", Object.class);
		// Boolean developmentMode = (Boolean) valExpr.getValue(elContext);
		// TwilioCapability capability = new TwilioCapability(twilioSid,
		// twilioToken);
		// if (applicationSid != null && !applicationSid.isEmpty())
		// capability.allowClientOutgoing(applicationSid);
		// String client = injectionPoint.getAnnotated()
		// .getAnnotation(TwilioClientToken.class).client();
		// capability.allowClientIncoming(client);
		//
		// try {
		// return capability.generateToken();
		// } catch (DomainException e) {
		// e.printStackTrace();
		// }
		return null;
	}
}
