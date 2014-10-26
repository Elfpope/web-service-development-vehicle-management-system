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
	
	public User() {	}

	public User(int id, String email, String firstName, String lastName, String password,
			String role) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean isAdministrator(){
		return role.equals("Administrator");
	}

	public boolean isDriver(){
		return role.equals("Driver");
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
}
