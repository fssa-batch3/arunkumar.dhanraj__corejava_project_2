package com.fssa.creckett.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * @author ArunkumarDhanraj
 *
 */
public class ConnectionDb {
	// Getting Connection
	public Connection connect() throws SQLException {

		String dbURL;
		String dbUser;
		String dbPassword;

		if (System.getenv("CI") != null) {
			dbURL = System.getenv("dbURL");
			dbUser = System.getenv("dbUser");
			dbPassword = System.getenv("dbPassword");
		} else {
			Dotenv env = Dotenv.load();
			dbURL = env.get("dbURL");
			dbUser = env.get("dbUser");
			dbPassword = env.get("dbPassword");
		}

		return DriverManager.getConnection(dbURL, dbUser, dbPassword);

	}

}
