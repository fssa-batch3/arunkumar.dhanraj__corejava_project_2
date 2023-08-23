package com.fssa.creckett.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ArunkumarDhanraj
 *
 */
public class HelperFunctions {

//	Validation for the image
	public boolean validUrl(String url) {

		String regex = "\\bhttps://\\S+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);

		return matcher.matches();

	}

//  Validation for the message
	public boolean validMessage(String message) {

		return !message.trim().isEmpty() && message.trim().length() > 5;

	}

}
