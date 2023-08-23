package com.fssa.creckett.services;

import com.fssa.creckett.dao.UserDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.User;
import com.fssa.creckett.services.exceptions.ServiceException;
import com.fssa.creckett.validation.UserValidator;
import com.fssa.creckett.validation.exceptions.InvalidUserException;

public class UserService {

//	Registration for users
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		UserValidator validator = new UserValidator();

		boolean check = false;

		try {
			if (validator.validateUser(user)) {

				if (userDAO.createUser(user)) {
					System.out.println("User created successfully");
					check = true;
				}

			}
		} catch (DAOException | InvalidUserException e) {
			System.out.println(e.getMessage());
			throw new ServiceException("Error while creating user in service",e);
		}

		return check;

	}

//	Checking Login user
	public boolean loginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		UserValidator validator = new UserValidator();
//		if (user == null || user.getEmail().isEmpty() || user.getPassword().isEmpty())
//			return false;
//
//		UserDAO userDAO = new UserDAO();
//
//		ArrayList<User> listOfUsers = null;
//
//		try {
//			listOfUsers = userDAO.regiteredUsersList();
//		} catch (DAOException e) {
//			throw new ServiceException("Error in logging in");
//		}
//
//		for (User u : listOfUsers) {
//			if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
//				System.out.println("Logged in successfully");
//				return true;
//			}
//		}
//		return false;
		try {
			validator.validEmail(user.getEmail());
			validator.validPassword(user.getPassword());

			if ( userDAO.selectForLogin(user)) {
				System.out.println("Logged in successfully");
				return true;
			}
			
			System.out.println("Invalid email or password");
			return false;

		} catch (InvalidUserException | DAOException e) {
			System.out.println(e.getMessage());
			throw new ServiceException("Error in logging in",e);
		}

	}

//	Sample users
	public static void main(String[] args) {
//		User user1 = new User(2, "kumar", "kumar@gmail.com", "Jd12345*", "6366887738");
		User user2 = new User("arun19ict@gmail.com", "Jd12345*");

		try {
//			new UserService().registerUser(user1);
			new UserService().loginUser(user2);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
