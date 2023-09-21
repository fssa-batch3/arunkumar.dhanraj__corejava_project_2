package com.fssa.creckett.model;

import java.time.LocalDate;

/**
 * @author ArunkumarDhanraj
 *
 */
public class TurfBooking {

//	Attributes
	private int bookingId;
	private Turf turf;
	private User user;
	private LocalDate date;
	private String time;

//	Main constructor
	public TurfBooking(int bookingId, Turf turf, User user, LocalDate date, String time) {
		this.bookingId = bookingId;
		this.turf = turf;
		this.user = user;
		this.date = date;
		this.time = time;
	}

//	Constructor for booking the turf
	public TurfBooking(Turf turf, User user, LocalDate date, String time) {
		this.turf = turf;
		this.user = user;
		this.date = date;
		this.time = time;
	}

//	Getters and setters for the attibutes
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Turf getTurf() {
		return turf;
	}

	public void setTurf(Turf turf) {
		this.turf = turf;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TurfBooking [bookingId=" + bookingId + ", turf=" + turf + ", user=" + user + ", date=" + date
				+ ", time=" + time + "]";
	}

}
