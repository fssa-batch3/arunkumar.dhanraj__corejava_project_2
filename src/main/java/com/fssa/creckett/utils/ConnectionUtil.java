package com.fssa.creckett.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fssa.creckett.dao.exceptions.DAOException;

/**
 * @author ArunkumarDhanraj
 *
 */
public class ConnectionUtil {

	/**
	 * Getting Connection
	 * 
	 * @return Connection
	 */
	public Connection connect() throws DAOException {

		final String DBURL = System.getenv("dbURL");
		final String DBUSER = System.getenv("dbUser");
		final String DBPASSWORD = System.getenv("dbPassword");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (SQLException e) {
			throw new DAOException("Unable to connect database", e);
		} catch (ClassNotFoundException e) {
			throw new DAOException("Database driver class not found", e);
		}

	}

}
