package creckett.validation;

/**
 * @author ArunkumarDhanraj
 *
 */

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import creckett.dao.UserDAO;
import creckett.dao.exceptions.DAOException;
import creckett.model.User;
import creckett.validation.exceptions.InvalidUserException;

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

		if (matcher.matches() && name != null) {
			return true;
		} else {
			throw new InvalidUserException("Invalid Username");
		}

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

		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*()-_=+\\[\\]{}|;:',.<>?/]).{8,}$";
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
		else
			throw new InvalidUserException("Invalid email Id");

	}

//	Checking whether the email already exists
	public boolean isEmailExists(String email) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();

//		ArrayList<User> usersList = userDAO.regiteredUsersList();
//		for (User user : usersList) {
//			if (email.equals(user.getEmail())) {
//				throw new InvalidUserException(email + " is already exists");
//			}
//		}
//		return true;
		try {
			if (userDAO.selectByEmail(email)) {
				System.out.println(email + " is already exists");
				return false;
			}

			return true;
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			throw new InvalidUserException("Email already exists");
		}

	}

//	Checking whether the phone number already exists
	public boolean isNumberExists(String number) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();

//		ArrayList<User> usersList = userDAO.regiteredUsersList();
//		for (User user : usersList) {
//			if (number.equals(user.getPhonenumber())) {
//				throw new InvalidUserException(number + " is already exists");
//			}
//		}
//		return true;

		try {
			
			if (userDAO.selectByNumber(number)) {
				System.out.println(number + " is already exists");
			}
			
			return !userDAO.selectByNumber(number);
		} catch (DAOException e) {
			System.out.println(e.getMessage());
			throw new InvalidUserException("Phonenumber already exists");
		}

	}

}
