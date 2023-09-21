package com.fssa.creckett.validation;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.validation.exceptions.InvalidUserException;

/**
 * @author ArunkumarDhanraj
 *
 */
class TestUserValidator {

	/**
	 * Testing the Username validation
	 */

	@Test
	void testValidUsername() {
		UserValidator userValidator = new UserValidator();
		try {
			assertTrue(userValidator.validName("Arunkumar"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidUsername() {
		UserValidator userValidator = new UserValidator();
		try {

//			Starting with Number
			assertFalse(userValidator.validName("1Arun"));

//			Starting with Special Character
			assertFalse(userValidator.validName("@Arun"));

//			Including the spaces
			assertFalse(userValidator.validName("Arun kumar"));

		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Testing the email validation
	 */

	@Test
	void testValidEmail() {
		UserValidator userValidator = new UserValidator();

		try {
			assertTrue(userValidator.validEmail("arun19ict@gmail.com"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidEmailWithoutAtSymbol() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validEmail("arun19ictgmail.com"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidEmailWithoutcom() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validEmail("arun19ict@"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Testing the password validation
	 */

	@Test
	void testValidPassword() {
		UserValidator userValidator = new UserValidator();
		try {
			assertTrue(userValidator.validPassword("Arun@2002"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInValidPasswordWithoutNumbers() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validPassword("Arun@"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInValidPasswordShorterLength() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validPassword("Ar@22"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Testing the phone number validation
	 */

	@Test
	void testValidMobileNo() {
		UserValidator userValidator = new UserValidator();
		try {
			assertTrue(userValidator.validPhoneNumber("6385102549"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testInvalidMobileNo() {
		UserValidator userValidator = new UserValidator();
		try {

//			Less then 10 numbers
			assertFalse(userValidator.validPhoneNumber("98765765"));

//			Greater than 10 numbers
			assertFalse(userValidator.validPhoneNumber("98765432101"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidMobileNoWithPrefixOtherThan6789() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validPhoneNumber("5678901238"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidMobileNoWithNonNumericCharacters() {
		UserValidator userValidator = new UserValidator();
		try {
			assertFalse(userValidator.validPhoneNumber("9876a43210"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

}
