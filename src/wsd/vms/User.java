package wsd.vms;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "id")
	private int id;
	@XmlElement(name = "email")
	private String email;
	@XmlElement(name = "firstName")
	private String firstName;
	@XmlElement(name = "lastName")
	private String lastName;
	@XmlElement(name = "password")
	private String password;
	@XmlElement(name = "role")
	private String role;

	private final String ADMIN = "Administrator";
	private final String DRIVER = "Driver";
	
	/** creates new blank user */
	public User() {
	}

	/** creates new user */
	/**
	 * @param id ID of the user
	 * @param email Email of the user
	 * @param firstName First name of the user
	 * @param lastName Last name of the user
	 * @param password Password of the user
	 * @param role Role of the user
	 */
	public User(int id, String email, String firstName, String lastName,
			String password, String role) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

	/** returns the user ID */
	public int getId() {
		return id;
	}

	/** sets the user ID */
	public void setId(int id) {
		this.id = id;
	}

	/** returns the email */
	public String getEmail() {
		return email;
	}

	/** sets the email */
	public void setEmail(String email) {
		this.email = email;
	}

	/** returns the first name */
	public String getFirstName() {
		return firstName;
	}

	/** sets the first name */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** returns the last name */
	public String getLastName() {
		return lastName;
	}

	/** sets the last name */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** returns the password */
	public String getPassword() {
		return password;
	}

	/** sets the password */
	public void setPassword(String password) {
		this.password = password;
	}

	/** returns the user role */
	public String getRole() {
		return role;
	}

	/** sets the user role */
	public void setRole(String role) {
		this.role = role;
	}

	/** returns true if current user is administrator */
	public boolean isAdministrator() {
		return role.equals(ADMIN);
	}

	/** returns true if current user is driver */
	public boolean isDriver() {
		return role.equals(DRIVER);
	}

	/** returns first name and last name */
	public String getFullName() {
		return firstName + " " + lastName;
	}
}
