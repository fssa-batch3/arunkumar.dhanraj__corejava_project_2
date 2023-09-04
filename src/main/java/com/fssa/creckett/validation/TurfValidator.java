package com.fssa.creckett.validation;

import java.util.List;

import com.fssa.creckett.model.Turf;
import com.fssa.creckett.utils.HelperFunctions;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

public class TurfValidator {

	/**
	 * Vaidating the image Url and details
	 * 
	 * @param turf
	 * @return boolean
	 * @throws InvalidTurfException
	 */

	public boolean validateTurf(Turf turf) throws InvalidTurfException {

		return validateUrl(turf.getImage()) && validateDetails(turf.getMessage());

	}

	/**
	 * Validating the turf list
	 * 
	 * @param turflist
	 * @throws InvalidTurfException
	 */

	public void validateTurfList(List<Turf> turflist) throws InvalidTurfException {

		if (turflist == null || turflist.isEmpty())
			throw new InvalidTurfException("There is no turf hosted");

	}
	
	/**
	 * Validating the turf object
	 * @param turf
	 * @throws InvalidTurfException
	 */

	public void validateTurfObject(Turf turf) throws InvalidTurfException {
		if (turf == null)
			throw new InvalidTurfException("Error in showing the turf details");
	}

	/**
	 * validating the turf image url
	 * 
	 * @param url
	 * @return boolean
	 * @throws InvalidTurfException
	 */
	public boolean validateUrl(String url) throws InvalidTurfException {

		HelperFunctions helper = new HelperFunctions();

		if (helper.validUrl(url))
			return true;

		throw new InvalidTurfException("The image URL is invalid");
	}

	/**
	 * validating the turf details
	 * 
	 * @param details
	 * @return boolean
	 * @throws InvalidTurfException
	 */
	public boolean validateDetails(String details) throws InvalidTurfException {

		HelperFunctions helper = new HelperFunctions();

		if (helper.validMessage(details))
			return true;

		throw new InvalidTurfException("The turf detail is too short");
	}
}
