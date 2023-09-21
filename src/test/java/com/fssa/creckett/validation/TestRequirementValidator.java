package com.fssa.creckett.validation;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.Requirement;
import com.fssa.creckett.validation.exceptions.InvalidRequirementException;

class TestRequirementValidator {

	@Test
	void testRequirementMessageSuccess() {

		Requirement requirement = new Requirement("I want a batsman");
		RequirementValidator validate = new RequirementValidator();

		try {
			assertTrue(validate.validateRequirement(requirement));
		} catch (InvalidRequirementException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRequirementMessageFailure() {

		Requirement requirement = new Requirement("I     ");
		RequirementValidator validate = new RequirementValidator();

		try {
			assertFalse(validate.validateRequirement(requirement));
		} catch (InvalidRequirementException e) {
			e.printStackTrace();
		}

	}

}
