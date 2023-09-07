package com.fssa.creckett.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.fssa.creckett.model.User;
import com.fssa.creckett.services.exceptions.ServiceException;

/**
 * @author ArunkumarDhanraj
 *
 */
class TestUserService {

	/**
	 * Test cases for Registration feature
	 */

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

	/**
	 * Test cases for Login feature
	 */

	@Test
	void testLoginSuccess() {

		UserService service = new UserService();

		User regUser = new User("kumaresan", "arun29@gmail.com", "Arun@2022", "6345456767");
		User logUser = new User("arun29@gmail.com", "Arun@2022");

		try {
			service.registerUser(regUser);
			assertTrue(service.loginUser(logUser));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

//	test login by incorrect input	
	@Test
	void testLoginFail() {

		UserService service = new UserService();

		User regUser = new User("Kumar", "kumar@gmail.com", "Kumar@2022", "6345455678");

//		Giving the wrong email id
		User logUser = new User("arun99@gmail.com", "akumm@2011");

		try {
			service.registerUser(regUser);
			assertFalse(service.loginUser(logUser));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@AfterAll
	static void deleteByEmail() {

		UserService service = new UserService();

		try {
			service.deleteUserByemail("arun29@gmail.com");
			service.deleteUserByemail("kumar@gmail.com");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test cases for get User by email
	 */

	@Test
	void testGetUserbyEmailSuccess() {

		UserService service = new UserService();

		try {

			User user = service.getUser("arun19ict@gmail.com");

			assertNotNull(user);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetUserbyEmailfailure() {

		UserService service = new UserService();

		try {

			User user = service.getUser("bharath@gmail.com");

			assertNull(user);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test cases for Get all users list
	 */

	@Test
	void testGetAllUsers() {

		UserService service = new UserService();

		try {
			List<User> listUsers = service.listUsers();
			
			assertNotNull(listUsers);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
