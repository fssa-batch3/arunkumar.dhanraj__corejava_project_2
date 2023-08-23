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

		try {

			return validator.validateUser(user) && userDAO.createUser(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException("Error while creating user in service", e);
		}

	}

//	Checking Login user
	public boolean loginUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		UserValidator validator = new UserValidator();

		try {
			validator.validEmail(user.getEmail());
			validator.validPassword(user.getPassword());

			return userDAO.selectForLogin(user);

		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException("Error in logging in", e);
		}

	}

}
