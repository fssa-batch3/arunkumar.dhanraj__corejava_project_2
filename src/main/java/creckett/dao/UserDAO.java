package creckett.dao;

/**
 * @author ArunkumarDhanraj

 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import creckett.dao.exceptions.DAOException;
import creckett.model.User;
import io.github.cdimascio.dotenv.Dotenv;

public class UserDAO {

// Getting Connection
	public static Connection connect() throws SQLException {

		String dbURL;
		String dbUser;
		String dbPassword;
		
		
		
		
		

		if (System.getenv("CI") != null) {
			dbURL = System.getenv("DB_URL");
			dbUser = System.getenv("DB_USER");
			dbPassword = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			dbURL = env.get("DB_URL");
			dbUser = env.get("DB_USER");
			dbPassword = env.get("DB_PASSWORD");
		}

		return DriverManager.getConnection(dbURL, dbUser, dbPassword);

	}

//	Creating Statement and inserting the user's value
	public boolean createUser(User user) throws DAOException {

		final String QUERY = "INSERT INTO users (name,email,password,phonenumber) VALUES (?,?,?,?)";
		int row = 0;
		try (PreparedStatement std = connect().prepareStatement(QUERY)) {

			std.setString(1, user.getName());
			std.setString(2, user.getEmail());
			std.setString(3, user.getPassword());
			std.setString(4, user.getPhonenumber());

			row = std.executeUpdate();
			System.out.println("Rows affected: " + row);

		} catch (SQLException e) {
			throw new DAOException("Error in inserting the user's value", e);
		}

		return row > 0;

	}

//	Delete the user
	public boolean deleteUser(String email) throws DAOException {

		final String DELETEQUERY = "DELETE FROM users where email=?";

		int row = 0;

		try (PreparedStatement std = connect().prepareStatement(DELETEQUERY)) {

			std.setString(1, email);

			row = std.executeUpdate();

			System.out.println("Deleted row: " + row);

		} catch (SQLException e) {
			throw new DAOException("Error in deleting the user", e);
		}

		return row > 0;

	}

//	Getting the register user's details
	public ArrayList<User> regiteredUsersList() throws DAOException {

		ArrayList<User> users = new ArrayList<>();
		final String SELECTQUERY = "Select * from users";
		try (Statement std = connect().createStatement(); ResultSet rs = std.executeQuery(SELECTQUERY)) {

			while (rs.next()) {

				String email = rs.getString("email");
				String password = rs.getString("password");
				String number = rs.getString("phonenumber");

				User user = new User();
				user.setEmail(email);
				user.setPassword(password);
				user.setPhonenumber(number);

				users.add(user);
			}

		} catch (SQLException e) {
			throw new DAOException("Error in resultSet", e);
		}

		return users;

	}

//	Getting the user's details by email id
	public boolean selectByEmail(String email) throws DAOException {
		final String SELECTQUERY = "SELECT email FROM users WHERE email = ?";

		try (PreparedStatement pstmt = connect().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the email exists
			}
		} catch (SQLException e) {
			throw new DAOException("Error in getting the email exist", e);
		}
	}

//	Getting the user's details by Phone number
	public boolean selectByNumber(String number) throws DAOException {
		final String SELECTQUERY = "SELECT phonenumber FROM users WHERE phonenumber = ?";

		try (PreparedStatement pstmt = connect().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, number);

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the number exists
			}

		} catch (SQLException e) {
			throw new DAOException("Error in getting the number existence", e);
		}
	}

//	Getting the email and password for log in
	public boolean selectForLogin(User user) throws DAOException {

		final String SELECTQUERY = "SELECT email, password FROM users WHERE email = ? AND password = ?";

		try (PreparedStatement pstmt = connect().prepareStatement(SELECTQUERY)) {

			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());

			try (ResultSet rs = pstmt.executeQuery()) {
				return rs.next(); // Return true if the user email and password exists
			}

		} catch (SQLException e) {
			throw new DAOException("Error in loggin in", e);
		}

	}

}
