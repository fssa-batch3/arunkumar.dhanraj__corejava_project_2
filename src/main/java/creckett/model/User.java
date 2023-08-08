package creckett.model;

/**
 * @author ArunkumarDhanraj
 *
 */

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private String phonenumber;
	
// constructor for registration
	public User(String name, String email, String password, String phonenumber) {
		this.name = name;
		this.email = email;	
		this.password = password;
		this.phonenumber = phonenumber;
	}

//	constructor for login
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

//	default
	public User() {

	}

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

	@Override
	public String toString() {
		return "User [ name = " + name + ", email = " + email + ", password = " + password + ", phonenumber = "
				+ phonenumber + " ]";
	}

}
