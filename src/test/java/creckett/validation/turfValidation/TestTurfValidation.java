package creckett.validation.turfValidation;

/**
 * @author ArunkumarDhanraj
 *
 */

import creckett.validation.TurfValidator;
import creckett.validation.exceptions.InvalidTurfException;
import creckett.model.Turf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class TestTurfValidation {

	@Test
	void testTurfImageAndDetailsSuccess() {

		Turf turf = new Turf("https://www.example.com", "Chennai chennai");
		TurfValidator validate = new TurfValidator(turf);

		try {
			assertTrue(validate.validateAll());
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testTurfImageFailure() {

		Turf turf = new Turf("www.example.com", "Chennai");
		TurfValidator validate = new TurfValidator(turf);

		try {
			assertFalse(validate.validateAll());
		} catch (InvalidTurfException e) {
			e.printStackTrace();
			
		}

	}
	
	@Test
	void testTurfDetailsFailure() {

		Turf turf = new Turf("https://www.example.com", "Chen");
		TurfValidator validate = new TurfValidator(turf);

		try {
			assertFalse(validate.validateAll());
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}

}
