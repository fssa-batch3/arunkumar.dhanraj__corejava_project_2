package com.fssa.creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.User;
import com.fssa.creckett.services.exceptions.ServiceException;

class TestRegisterFeature {

	@Test
	void testRegisterSuccess() {
		UserService service = new UserService();
		User user = new User("Kumar", System.nanoTime() + "@gmail.com", "Arun@2022", "6678954321");

		try {
			assertTrue(service.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	void testRegisterFail() {
		UserService service = new UserService();
//		given the already registered user's email
		User user = new User("Arunkumar", "arun19ict@gmail.com", "Arun@2022", "6345456767");

		try {
			assertFalse(service.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
