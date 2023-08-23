package com.fssa.creckett.validation;

import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.utils.HelperFunctions;
import com.fssa.creckett.validation.exceptions.InvalidRequirementException;


public class RequirementValidator  {

	public boolean validateRequirement(Requirement requirement) throws InvalidRequirementException {

		HelperFunctions helper = new HelperFunctions();

		if (helper.validMessage(requirement.getMessage()))
			return true;

		throw new InvalidRequirementException("Error while validating the requirement");

	}
	


}
