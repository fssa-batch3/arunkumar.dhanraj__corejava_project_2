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

class TestPhoneNumberValidation {
	
	@Test
	 void TestValidMobileNo() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("Your mobile number is correct");
			assertTrue(userValidator.validPhoneNumber("9876543210"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	@Test
	 void TestInvalidMobileNoWithLessThan10Digits() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("Mobile number should be in 10 digits only");
			assertFalse(userValidator.validPhoneNumber("987654321"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	@Test
	 void TestInvalidMobileNoWithMoreThan10Digits() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("Mobile number contains 10 digits only");
			assertFalse(userValidator.validPhoneNumber("98765432101"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	@Test
	 void TestInvalidMobileNoWithPrefixOtherThan6789() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("Mobile number do not start with 5 ");
			assertFalse(userValidator.validPhoneNumber("5678901234"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	@Test
	 void TestInvalidMobileNoWithNonNumericCharacters() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("Mobile number contains integer");
			assertFalse(userValidator.validPhoneNumber("9876a43210"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}

	
	
	@Test
	 void TestInvalidMobileNoStartingWithZero() {
		UserValidator userValidator = new UserValidator();
		try {
			System.out.println("Mobile number do not start with 0 ");
			assertFalse(userValidator.validPhoneNumber("0123456789"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
}
