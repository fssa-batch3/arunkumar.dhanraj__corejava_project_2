package com.fssa.creckett.validation;

import java.util.List;

import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.utils.HelperFunctions;
import com.fssa.creckett.validation.exceptions.InvalidRequirementException;


public class RequirementValidator  {

	/**
	 * Validating the requirement message
	 * @param requirement
	 * @return boolean
	 * @throws InvalidRequirementException
	 */
	public boolean validateRequirement(Requirement requirement) throws InvalidRequirementException {

		HelperFunctions helper = new HelperFunctions();

		if (helper.validMessage(requirement.getMessage()))
			return true;

		throw new InvalidRequirementException("Requirement message is less");

	}
	
	
	/**
	 * validating the requirement list 
	 * @param reqList
	 * @throws InvalidRequirementException
	 */
	public void validateRequirementList(List<Requirement> reqList)throws InvalidRequirementException {
		
		if(reqList.isEmpty())
			throw new InvalidRequirementException("There are no requirements");
		
	}


}
