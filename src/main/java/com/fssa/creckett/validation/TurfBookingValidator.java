package com.fssa.creckett.validation;

import java.time.LocalDate;

import com.fssa.creckett.model.TurfBooking;
import com.fssa.creckett.utils.HelperFunctions;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

/**
 * @author ArunkumarDhanraj
 *
 */
public class TurfBookingValidator {

	/**
	 * validating the date and time in one method for turf booking
	 * 
	 * @param booking
	 * @return boolean
	 * @throws InvalidTurfException
	 */
	public boolean validateTurfBooking(TurfBooking booking) throws InvalidTurfException {
		return validateDate(booking.getDate()) && validateTime(booking.getTime());
	}

	/**
	 * Validating the date
	 * 
	 * @param date
	 * @return boolean
	 * @throws InvalidTurfException
	 */
	public boolean validateDate(LocalDate date) throws InvalidTurfException {

		HelperFunctions helper = new HelperFunctions();

		if (helper.validDate(date))
			return true;

		throw new InvalidTurfException("Invalid Date");
	}

	/**
	 * Validating the time
	 * 
	 * @param time
	 * @return boolean
	 * @throws InvalidTurfException
	 */
	public boolean validateTime(String time) throws InvalidTurfException {

		HelperFunctions helper = new HelperFunctions();

		if (helper.validTime(time))
			return true;

		throw new InvalidTurfException("Invalid Time");
	}

}
