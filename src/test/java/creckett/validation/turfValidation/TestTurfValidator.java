package creckett.validation.turfValidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.Turf;
import com.fssa.creckett.validation.TurfValidator;
import com.fssa.creckett.validation.exceptions.InvalidTurfException;

class TestTurfValidator {

	@Test
	void testTurfImageAndDetailsSuccess() {

		Turf turf = new Turf("https://www.example.com", System.nanoTime()+"Perungudi chennai");
		TurfValidator validate = new TurfValidator();

		try {
			assertTrue(validate.validateTurf(turf));
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}

	@Test
	void testTurfImageFailure() {

		Turf turf = new Turf("www.example.com", "Chennai");
		TurfValidator validate = new TurfValidator();

		try {
			assertFalse(validate.validateTurf(turf));
		} catch (InvalidTurfException e) {
			e.printStackTrace();
			
		}

	}
	
	@Test
	void testTurfDetailsFailure() {

		Turf turf = new Turf("https://www.example.com", "Chen");
		TurfValidator validate = new TurfValidator();

		try {
			assertFalse(validate.validateTurf(turf));
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}

	}

}
