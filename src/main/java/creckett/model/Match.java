package creckett.model;

import java.time.LocalDate;

public class Match {

//	Attributes
	private LocalDate matchDate;
	private String matchPlace;

//	Default constructor
	public Match() {

	}

//	Main constructor
	public Match(LocalDate date, String place) {
		this.matchDate = date;
		this.matchPlace = place;
	}

//	Getters and setters
	public LocalDate getDate() {
		return matchDate;
	}

	public void setDate(LocalDate date) {
		this.matchDate = date;
	}

	public String getPlace() {
		return matchPlace;
	}

	public void setPlace(String place) {
		this.matchPlace = place;
	}

}
