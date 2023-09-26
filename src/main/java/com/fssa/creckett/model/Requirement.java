package com.fssa.creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

public class Requirement {

	// Attributes for requirement
	private int reqId;
	private String message;
	private User postedBy;

// default constructor
	public Requirement() {

	}
	
//	Message constructor
	public Requirement(String message) {
		this.message = message;
	}

//	Main constructor
	public Requirement(String message,User postedBy) {
		this.message = message;
		this.postedBy = postedBy;
	}

//	constructor for update
	public Requirement(int reqId, String message,User postedBy) {
		this.reqId = reqId;
		this.message = message;
		this.postedBy = postedBy;
	}

	// getters and setters
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

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	@Override
	public String toString() {
		return "Requirement [reqId=" + reqId + ", message=" + message + ", postedBy=" + postedBy + "]";
	}

}
