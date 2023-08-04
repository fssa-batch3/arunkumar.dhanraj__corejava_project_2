package creckett.validation.userValidation;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import creckett.validation.UserValidator;
import creckett.validation.exceptions.InvalidUserException;

class TestEmailValidation {

	@Test
	void testValidEmail() {
		UserValidator userValidator = new UserValidator();

		try {
			assertTrue(userValidator.validEmail("arun19ict@gmail.com"));
			System.out.println("Your email is valid");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidEmailWithoutAtSymbol() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validEmail("arun19ictgmail.com"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidEmailWithoutcom() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validEmail("arun19ict@"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
