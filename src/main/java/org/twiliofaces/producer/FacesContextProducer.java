package org.twiliofaces.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FacesContextProducer {

	@Produces
	@RequestScoped
	FacesContext getFacesContext() {

		return FacesContext.getCurrentInstance();

	}

}