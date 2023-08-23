package com.fssa.creckett.validation;

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

	public boolean validateUser(User user) throws InvalidUserException {

		return validName(user.getName()) && validPhoneNumber(user.getPhonenumber()) && validPassword(user.getPassword())
				&& validEmail(user.getEmail()) && isEmailExists(user.getEmail())
				&& isNumberExists(user.getPhonenumber());

	}

//	validating username
	public boolean validName(String name) throws InvalidUserException {

		String regex = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);

		if (matcher.matches() && name != null)
			return true;

		throw new InvalidUserException("Invalid Username");

	}

//	validating phonenumber
	public boolean validPhoneNumber(String number) throws InvalidUserException {

		String regex = "^[6-9]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);

		if (matcher.matches() && number != null)
			return true;
		else
			throw new InvalidUserException("Invalid Phone number");

	}

//	validating password
	public boolean validPassword(String password) throws InvalidUserException {

		String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches() && password != null)
			return true;
		else
			throw new InvalidUserException("Invalid Password");

	}

//	validating email 
	public boolean validEmail(String email) throws InvalidUserException {

		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches() && email != null)
			return true;

		throw new InvalidUserException("Invalid email Id");

	}

//	Checking whether the email already exists
	public boolean isEmailExists(String email) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();

		try {
			return userDAO.selectByEmail(email);
		} catch (DAOException e) {
			throw new InvalidUserException("Email already exists");
		}

	}

//	Checking whether the phone number already exists
	public boolean isNumberExists(String number) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();

		try {

			userDAO.selectByNumber(number);

			return !userDAO.selectByNumber(number);
		} catch (DAOException e) {
			throw new InvalidUserException("Phonenumber already exists");
		}

	}

}
