package com.fssa.creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

public class Requirement {

	// Attributes for requirement
	private int reqId;
	private String message;

//	default constrctor
	public Requirement() {

	}

//	Main constrctor
	public Requirement(String message) {
		this.message = message;
	}

//	constrctor for update
	public Requirement(int reqId, String message) {
		this.reqId = reqId;
		this.message = message;
	}


	//	getters and setters 
	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Requirement [reqId=" + reqId + ", message=" + message + "]";
	}

}
