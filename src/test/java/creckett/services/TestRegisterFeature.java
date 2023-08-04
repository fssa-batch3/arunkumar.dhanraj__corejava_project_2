package creckett.services;

/**
 * @author ArunkumarDhanraj
 *
 */

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import creckett.model.User;
import creckett.dao.UserDAO;
import creckett.dao.exceptions.DAOException;
import creckett.services.exceptions.ServiceException;

class TestRegisterFeature {

//	test by by correct input
	@Test
	void testRegisterSuccess() {
		UserService service = new UserService();
		User user = new User("Arunkumar", "arun18ccc@gmail.com", "Arun@2022", "6678954321");

		try {
			assertTrue(service.registerUser(user));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

//	test by by incorrect input
	@Test
	void testRegisterFail() {
		UserService service = new UserService();
		User user = new User("Arunkumar", "arun18gmail.com", "Arun@2022", "6345456767");

		try {
			assertFalse(service.registerUser(user));
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterAll
	static void deleteByEmail() {
		UserDAO dao = new UserDAO();

		try {
			dao.deleteUser("arun18ccc@gmail.com");
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
