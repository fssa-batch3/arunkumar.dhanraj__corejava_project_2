package com.fssa.creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

public class Turf {

	/**
	 * Attributes for turf
	 */
	private int turfId;
	private String image;
	private String message;
	private User createdBy;



	/**
	 * Default constructor
	 */
	public Turf() {

	}

	/**
	 * Main constructor
	 * 
	 * @param image
	 * @param message
	 */
	public Turf(String image, String message) {
		this.image = image;
		this.message = message;
	}

	/**
	 * constructor for update
	 * 
	 * @param turfId
	 * @param image
	 * @param message
	 */
	public Turf(int turfId, String image, String message) {
		this.turfId = turfId;
		this.image = image;
		this.message = message;
	}

	/**
	 * Getters and setters for attributes
	 * 
	 * @return
	 */
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
	
	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}



	/**
	 * toString method for the turf
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Turf [turfId=" + turfId + ", image=" + image + ", message=" + message + ", createdBy=" + createdBy
				+ "]";
	}


}
