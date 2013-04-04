package org.twiliofaces.event;

public class TwimlEvent {
	private String twiml;

	public TwimlEvent() {
	}

	public TwimlEvent(String twiml) {
		this.twiml = twiml;
	}

	public String getTwiml() {
		return twiml;
	}
}
