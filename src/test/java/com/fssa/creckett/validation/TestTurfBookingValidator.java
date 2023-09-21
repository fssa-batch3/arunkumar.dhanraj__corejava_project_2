package com.fssa.creckett.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.creckett.validation.exceptions.InvalidTurfException;

/**
 * @author ArunkumarDhanraj
 *
 */
class TestTurfBookingValidator {

	private TurfBookingValidator validator;

	@BeforeEach
	public void setUp() {
		validator = new TurfBookingValidator();
	}

//	 Tests for Validate Date

	@Test
	void testValidDate() {
		LocalDate validDate = LocalDate.now().plusDays(1); // Tomorrow
		try {
			assertTrue(validator.validateDate(validDate));
		} catch (InvalidTurfException e) {
			fail();
		}
	}

	@Test
	void testToday() {
		LocalDate today = LocalDate.now();
		try {
			assertTrue(validator.validateDate(today));
		} catch (InvalidTurfException e) {
			fail();
		}
	}

	@Test
	void testPastDate() {
		LocalDate pastDate = LocalDate.now().minusDays(1); // Yesterday
		try {
			assertFalse(validator.validateDate(pastDate));
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testNullDate() {
		try {
			assertFalse(validator.validateDate(null)); // Null date
		} catch (InvalidTurfException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testFutureDate() {
		LocalDate futureDate = LocalDate.now().plusMonths(1); // One month from today
		try {
			assertTrue(validator.validateDate(futureDate));
		} catch (InvalidTurfException e) {
			fail();
		}
	}

	@Test
	void testLeapYear() {
		LocalDate leapYearDate = LocalDate.of(2024, 2, 29); // Leap year date
		try {
			assertTrue(validator.validateDate(leapYearDate));
		} catch (InvalidTurfException e) {
			fail();
		}

	}

//	Tests for validate time

	@Test
	void testValidTime() {
		try {
			assertTrue(validator.validateTime("08AM - 09AM"));
			assertTrue(validator.validateTime("01PM - 02PM"));
		} catch (InvalidTurfException e) {
			fail();
		}

	}

	@Test
	void testInvalidTimeFormat() {
		assertThrows(InvalidTurfException.class, () -> validator.validateTime("8AM-09AM"));
		assertThrows(InvalidTurfException.class, () -> validator.validateTime("8:00 AM - 09:00 AM"));
		assertThrows(InvalidTurfException.class, () -> validator.validateTime("08AM 09AM"));
		assertThrows(InvalidTurfException.class, () -> validator.validateTime("08 AM - 09 AM"));
	}

	@Test
	void testInvalidTimeRange() {
		assertThrows(InvalidTurfException.class, () -> validator.validateTime("08AM - 13PM"));
	}

}
