package creckett.validation.requirementValidation;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import creckett.model.Requirement;
import creckett.validation.RequirementValidator;
import creckett.validation.exceptions.InvalidTurfException;

class TestRequirementValidation {

	@Test
	void testRequirementMessageSuccess() {

		Requirement requirement = new Requirement("I want a batsman");
		RequirementValidator validate = new RequirementValidator(requirement);

		try {
			assertTrue(validate.validateAll());
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	void testRequirementMessageFailure() {

		Requirement requirement = new Requirement("I     ");
		RequirementValidator validate = new RequirementValidator(requirement);

		try {
			assertFalse(validate.validateAll());
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}

}
