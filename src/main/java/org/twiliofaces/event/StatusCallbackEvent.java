package org.twiliofaces.event;

public class StatusCallbackEvent {
	private String callSid;
	private String accountSid;
	private String from;
	private String to;
	private String callStatus;
	private String apiVersion;
	private String direction;
	private String forwardedFrom;
	private String callerName;

	public StatusCallbackEvent() {
	}

	public StatusCallbackEvent(String callSid, String accountSid, String from,
			String to, String callStatus, String apiVersion, String direction,
			String forwardedFrom, String callerName) {
		this.callSid = callSid;
		this.accountSid = accountSid;
		this.from = from;
		this.to = to;
		this.callStatus = callStatus;
		this.apiVersion = apiVersion;
		this.direction = direction;
		this.forwardedFrom = forwardedFrom;
		this.callerName = callerName;
	}

	@Override
	public String toString() {
		return "StatusCallbackEvent [callSid=" + callSid + ", accountSid="
				+ accountSid + ", from=" + from + ", to=" + to
				+ ", callStatus=" + callStatus + ", apiVersion=" + apiVersion
				+ ", direction=" + direction + ", forwardedFrom="
				+ forwardedFrom + ", callerName=" + callerName + "]";
	}

	public String getCallSid() {
		return callSid;
	}

	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getForwardedFrom() {
		return forwardedFrom;
	}

	public void setForwardedFrom(String forwardedFrom) {
		this.forwardedFrom = forwardedFrom;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

}
