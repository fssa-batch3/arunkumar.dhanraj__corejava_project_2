package com.fssa.creckett.utils;

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

}
