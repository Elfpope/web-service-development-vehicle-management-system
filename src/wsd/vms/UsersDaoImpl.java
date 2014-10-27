package wsd.vms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBException;

public class UsersDaoImpl implements IUsersDao, Serializable {
	private static final long serialVersionUID = 1L;
	private XMLService xmlService;
	private Users users;

	/** creates blank user data access object implementation */
	public UsersDaoImpl() {
		xmlService = new XMLService();
	}

	/** creates new user data access object implementation */
	/**
	 * @param xmlService Service for marshaling and unmarshaling XML
	 * @throws JAXBException
	 * @throws IOException
	 */
	public UsersDaoImpl(XMLService xmlService) throws JAXBException,
			IOException {
		this.xmlService = xmlService;
		users = xmlService.unmarshallUsers();
	}

	/** returns the list of users */
	@Override
	public Users getUsers() {
		return users;
	}

	/** returns a user based on email and password */
	@Override
	public User getUser(String email, String password) {
		return users.login(email, password);
	}

	/** returns user ID based on email */
	@Override
	public int getUserId(String email) {
		return users.getUserId(email);
	}
	
	/** adds user object to list of users */
	@Override
	public void addUser(User user) {
		int id = users.getUsers().size() + 1;
		user.setId(id);
		if (checkUser(user)) {
			users.addUser(user);
			setUsers(users);
		}
	}

	/** sets the users by marshaling XML */
	@Override
	public void setUsers(Users users) {
		this.users = users;
		try {
			xmlService.marshallUsers(users);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/** checks user's variables for validity */
	public boolean checkUser(User user) {
		if (((isValidId(user.getId()) 
				&& isValidEmail(user.getEmail()))
				&& (isValidName(user.getFirstName()))
				&& (isValidName(user.getLastName()))
				&& (isValidPassword(user.getPassword())) 
				&& (isCorrectRole(user.getRole())))) {
			return true;
		}
		System.out.println("User Register Failure due to invalid field input");
		return false;
	}

	/** id validation: digit higher than 0 */
	public boolean isValidId(int id) {
		if (id >= 0)
			return true;
		return false;
	}

	/** email validation: follows standard email regex */
	public boolean isValidEmail(String email) {
		String regex = ".*@.*\\.(com|gov|org|net|edu)\\.?.*";
		if (email.matches(regex))
			return true;
		return false;
	}

	/** name validation: must contain valid letters */
	public boolean isValidName(String name) {
		String regex = "[a-zA-Z]*";
		if (name.matches(regex))
			return true;
		return false;
	}

	/** password validation: any lower or upper case letters or digits */
	public boolean isValidPassword(String password) {
		String regex = "[a-zA-Z0-9]*";
		if (password.matches(regex))
			return true;
		return false;
	}

	/** role validation: must equal driver or administrator */
	public boolean isCorrectRole(String role) {
		if (role.equals("Driver") || role.equals("Administrator")) {
			return true;
		}
		return false;
	}
}
