package creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

import java.time.LocalDate;

class Features {

// Attributes for features
	private String image;
	private String message;
	private LocalDate date;
	private String place;

	//	Default Constructor
	protected Features() {

	}

//	Host turf constructor
	protected Features(String image, String message) {
		this.image = image;
		this.message = message;
	}

//	Host match constructor 
	protected Features(LocalDate date, String place) {
		this.date = date;
		this.place = place;
	}

//	Post requirements constructor 
	protected Features(String message) {
		this.message = message;
	}
	
	
//	Getters and setters for attributes
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
