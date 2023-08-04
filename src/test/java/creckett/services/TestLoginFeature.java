package creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import creckett.dao.UserDAO;
import creckett.dao.exceptions.DAOException;
import creckett.model.User;
import creckett.services.exceptions.ServiceException;

class TestLoginFeature {
	
//	test login by correct input
	@Test
	void testLoginSuccess() {
		UserService service = new UserService();
		User regUser = new User("Arunkumar", "arun29@gmail.com", "Arun@2022", "6345456767");
		User logUser = new User("arun29@gmail.com", "Arun@2022");

		try {
			assertTrue(service.registerUser(regUser));
			assertTrue(service.loginUser(logUser));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
//	test login by incorrect input	
	@Test
	void testLoginFail() {
		UserService service = new UserService();
		User regUser = new User("Kumar", "kumar@gmail.com", "Kumar@2022", "6345455678");
		User logUser = new User("arun@gmail.com", "akumm@2011");

		try {
			assertTrue(service.registerUser(regUser));
			assertFalse(service.loginUser(logUser));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterAll
	static void deleteByEmail() {
		UserDAO dao = new UserDAO();

		try {
			dao.deleteUser("arun29@gmail.com");
			dao.deleteUser("kumar@gmail.com");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}
	
	

}
