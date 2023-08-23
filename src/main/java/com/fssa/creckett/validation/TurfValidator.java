package com.fssa.creckett.validation;

import com.fssa.creckett.model.Turf;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;
import com.fssa.creckett.utils.HelperFunctions;

public class TurfValidator {

	public boolean validateTurf(Turf turf) throws InvalidTurfException {

		HelperFunctions helper = new HelperFunctions();

		if (helper.validUrl(turf.getImage()) && helper.validMessage(turf.getMessage()))
			return true;

		throw new InvalidTurfException("Error while validating the turf");

	}

}
