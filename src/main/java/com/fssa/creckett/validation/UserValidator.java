package com.fssa.creckett.validation;

import java.util.List;

/**
 * @author ArunkumarDhanraj
 *
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.creckett.dao.UserDAO;
import com.fssa.creckett.dao.exceptions.DAOException;
import com.fssa.creckett.model.User;
import com.fssa.creckett.validation.exceptions.InvalidUserException;

public class UserValidator {

	/**
	 * Validating all the attributes
	 * 
	 * @param user
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean validateUser(User user) throws InvalidUserException {

		return validName(user.getName()) && validPhoneNumber(user.getPhonenumber()) && validPassword(user.getPassword())
				&& validEmail(user.getEmail()) && isEmailExists(user.getEmail());

	}

	/**
	 * validating username
	 * 
	 * @param name
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean validName(String name) throws InvalidUserException {

		String regex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);

		if (matcher.matches() && name != null)
			return true;

		throw new InvalidUserException("Invalid Username: Don't use special characters");

	}

	/**
	 * validating phonenumber
	 * 
	 * @param number
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean validPhoneNumber(String number) throws InvalidUserException {

		String regex = "^[6-9]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);

		if (matcher.matches() && number != null)
			return true;
		else
			throw new InvalidUserException("Invalid Phone number: Phone number should be in 10 numbers");

	}

	/**
	 * validating password
	 * 
	 * @param password
	 * @return
	 * @throws InvalidUserException
	 */
	public boolean validPassword(String password) throws InvalidUserException {

		String regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches() && password != null)
			return true;
		else
			throw new InvalidUserException(
					"Password must contain atleast 1 CAPITAL LETTER, small letter, special characters and numbers");

	}

	/**
	 * validating email
	 * 
	 * @param email
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean validEmail(String email) throws InvalidUserException {

		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches() && email != null)
			return true;

		throw new InvalidUserException("Invalid email");

	}

	/**
	 * Checking whether the email already exists
	 * 
	 * @param email
	 * @return boolean
	 * @throws InvalidUserException
	 */
	public boolean isEmailExists(String email) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();

		try {
			if (userDAO.selectByEmail(email))
				throw new InvalidUserException("Email is already registered");

			return true;
		} catch (DAOException e) {
			throw new InvalidUserException("Error in selecting by email");
		}

	}

	/**
	 * Validating the user's list
	 * @param userList
	 * @throws InvalidUserException
	 */
	public void validUsersList(List<User> userList) throws InvalidUserException {

		if (userList == null || userList.isEmpty())
			throw new InvalidUserException("Noone registered");

	}

	/**
	 * validating the logged user's details
	 * @param user
	 * @throws InvalidUserException
	 */
	public void validLoggedUser(User user) throws InvalidUserException {

		if (user == null)
			throw new InvalidUserException("Cannot get user's details");

	}

}
