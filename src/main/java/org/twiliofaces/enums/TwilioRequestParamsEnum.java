/*
 * Copyright 2013 twiliofaces.org.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.twiliofaces.enums;


public enum TwilioRequestParamsEnum {
	CallSid, 
	AccountSid, 
	From, 
	To, 
	CallStatus, 
	ApiVersion, 
	Direction, 
	ForwardedFrom, 
	CallerName,
	
	FromCity, 
	FromState, 
	FromZip, 
	FromCountry, 
	ToCity, 
	ToState, 
	ToZip, 
	ToCountry;
	public String toProperty(){
		return Character.toLowerCase(
				this.name().charAt(0)) + (this.name().length() > 1 ? this.name().substring(1) : "");
	}
}
