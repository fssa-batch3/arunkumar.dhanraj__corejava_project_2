package creckett.validation;

/**
 * @author ArunkumarDhanraj
 *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import creckett.validation.exceptions.InvalidTurfException;

public abstract class FeatureValidator {

//	Validation for the image
	protected boolean validImage(String image) throws InvalidTurfException {

		String regex = "\\bhttps://\\S+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(image);

		if (matcher.matches())
			return true;
		else
			throw new InvalidTurfException("Error in validating the image");

	}

//  Validation for the message
	protected boolean validMessage(String message) throws InvalidTurfException {

		if ( message.trim().isEmpty() || message.trim().length() < 5)
			throw new InvalidTurfException("Error in validating the message");
		else
			return true;

	}

//	need to validate the local date and place

//	abstract method to validate an object
	abstract boolean validateAll() throws InvalidTurfException;

}
