package com.fssa.creckett.model;

import java.time.LocalDate;

public class Match {

//	Attributes
	private int matchId;
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
	
//	constructor for update
	public Match(int matchId,LocalDate date, String place) {
		this.matchId = matchId;
		this.matchDate = date;
		this.matchPlace = place;
	}


	//	Getters and setters
	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public LocalDate getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(LocalDate matchDate) {
		this.matchDate = matchDate;
	}

	public String getMatchPlace() {
		return matchPlace;
	}

	public void setMatchPlace(String matchPlace) {
		this.matchPlace = matchPlace;
	}
	
	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", matchDate=" + matchDate + ", matchPlace=" + matchPlace + "]";
	}


}
