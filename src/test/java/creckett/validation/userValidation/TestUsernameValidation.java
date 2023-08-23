package creckett.validation.userValidation;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.validation.UserValidator;
import com.fssa.creckett.validation.exceptions.InvalidUserException;

class TestUsernameValidation {
	
	@Test
	 void testValidUsername() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("username is valid");
			assertTrue(userValidator.validName("Arunkumar"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	

	@Test
	 void testInvalidUsernameStartingWithNumber() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("username should not start with number");
			assertFalse(userValidator.validName("1Arun"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());;
		}
	}

	
	@Test
	 void testInvalidUsernameStartingWithSpecialCharacter() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("username should not contains special character");
			assertFalse(userValidator.validName("@Arun"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	 void testInvalidUsernameWithSpaces() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("username should not contains spaces ");
			assertFalse(userValidator.validName("Arun kumar"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
}
