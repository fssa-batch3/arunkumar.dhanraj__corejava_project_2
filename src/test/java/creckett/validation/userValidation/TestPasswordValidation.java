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

class TestPasswordValidation {

	@Test
	void TestValidPassword() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("The password is valid");
			assertTrue(userValidator.validPassword("Arun@2002"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}


	@Test
	 void TestInValidPasswordWithoutNumbers() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("The password is without numbers");
			assertFalse(userValidator.validPassword("Arun@"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void TestInValidPasswordWithoutCapitalLetters() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("The password is without Capital letters");
			assertFalse(userValidator.validPassword("arun@2002"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void TestInValidPasswordWithoutSmallLetters() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("The password is without small letters");
			assertFalse(userValidator.validPassword("ARUN@2002"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void TestInValidPasswordShorterLength() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("The password too short");
			assertFalse(userValidator.validPassword("Ar@22"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
