package com.fssa.creckett.model;

import java.io.Serializable;

/**
 * @author ArunkumarDhanraj
 *
 */

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Attributes for the User
	 */
	private int id;
	private String name;
	private String email;
	private String password;
	private String phonenumber;

	/**
	 * constructor for registration
	 * 
	 * @param name
	 * @param email
	 * @param password
	 * @param phonenumber
	 */
	public User(String name, String email, String password, String phonenumber) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
	}

	/**
	 * constructor for login
	 * 
	 * @param email
	 * @param password
	 */
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * Constructor after logged in
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param password
	 * @param phonenumber
	 */
	public User(int id, String name, String email, String password, String phonenumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
	}

	/**
	 * default constructor
	 */
	public User() {

	}

	/**
	 * Getter and setter for the attributes
	 * 
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * toString method for the user
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "User [ name = " + name + ", email = " + email + ", password = " + password + ", phonenumber = "
				+ phonenumber + " ]";
	}

}
