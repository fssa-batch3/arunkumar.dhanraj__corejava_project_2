package com.fssa.creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

public class Turf {

	// Attributes for turf
	private int turfId;
	private String image;
	private String message;

//	Default constructor 
	public Turf() {

	}

//	Main  constructor
	public Turf(String image, String message) {
		this.image = image;
		this.message = message;
	}

//	constructor for update
	public Turf(int turfId, String image, String message) {
		this.turfId = turfId;
		this.image = image;
		this.message = message;
	}

//	Getters and setters for attributes
	public int getTurfId() {
		return turfId;
	}

	public void setTurfId(int turfId) {
		this.turfId = turfId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Turf [turfId=" + turfId + ", image=" + image + ", message=" + message + "]";
	}

}
