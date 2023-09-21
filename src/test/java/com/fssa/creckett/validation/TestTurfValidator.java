package com.fssa.creckett.validation;

import static org.junit.Assert.assertFalse;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.Turf;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

class TestTurfValidator {

	@Test
	void testTurfImageAndDetailsSuccess() {

		Turf turf = new Turf("https://www.google.com/imgres?imgurl=https%3A%2F%2Fimg.freepik", " Perungudi chennai");
		TurfValidator validate = new TurfValidator();

		try {
			assertTrue(validate.validateTurf(turf));
		} catch (InvalidTurfException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testTurfImageFailure() {

		TurfValidator validate = new TurfValidator();

		try {
			assertFalse(validate.validateUrl("www.example.com"));
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testTurfDetailsFailure() {

		TurfValidator validate = new TurfValidator();

		try {
			assertFalse(validate.validateDetails("chen     "));
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}

	/**
	 * To-do need to write test cases for the turf listing method
	 */

}
