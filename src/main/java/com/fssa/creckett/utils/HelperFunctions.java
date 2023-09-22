package com.fssa.creckett.utils;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ArunkumarDhanraj
 *
 */

public class HelperFunctions {

	/**
	 * Validation for the image URL
	 * 
	 * @param imageUrl
	 * @return boolean
	 */
	public boolean validUrl(String imageUrl) {

		String regex = "\\bhttps://\\S+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(imageUrl);

		return matcher.matches();

	}

	/**
	 * Validation for the message
	 * 
	 * @param message
	 * @return boolean
	 */
	public boolean validMessage(String message) {

		return !message.trim().isEmpty() && message.trim().length() > 5;

	}

	/**
	 * Validating the date
	 * 
	 * @param date
	 * @return boolean
	 */
	public boolean validDate(LocalDate date) {
		if (date == null) {
			return false;
		}

		LocalDate today = LocalDate.now();
		return !date.isBefore(today); // Allow today and future dates
	}

	/**
	 * Validating the time
	 * 
	 * @param time
	 * @return boolean
	 */
	public boolean validTime(String time) {

		String regex = "^(?:[1-9]|1[0-2])(AM|PM) - (?:[1-9]|1[0-2])(AM|PM)$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(time);

		return matcher.matches();
	}

}
