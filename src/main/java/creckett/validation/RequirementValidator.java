package creckett.validation;

/**
 * @author ArunkumarDhanraj
 *
 */

import creckett.model.Requirement;
import creckett.validation.exceptions.InvalidTurfException;

public class RequirementValidator extends FeatureValidator {

//	Attibutes for requirement object
	private Requirement requirement;

	//	Default constructor
	public RequirementValidator() {

	}

//	Main constructor
	public RequirementValidator(Requirement requirement) {
		this.requirement = requirement;
	}
	
//	Getters and setters
	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
	
//  Method for validate all
	public boolean validateAll() throws InvalidTurfException {
		return validMessage(requirement.getMessage());
	}

}
