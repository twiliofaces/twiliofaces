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
