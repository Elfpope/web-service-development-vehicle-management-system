package wsd.vms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBException;

public class UsersDaoImpl implements IUsersDao, Serializable {

	private XMLService xmlService;
	private Users users;

	public UsersDaoImpl() {
		xmlService = new XMLService();
	}

	public UsersDaoImpl(XMLService xmlService) throws JAXBException,
			IOException {
		this.xmlService = xmlService;
		users = xmlService.unmarshallUsers();
	}

	@Override
	public Users getUsers() {
		return users;
	}

	@Override
	// retrieves a single user as per entered credential
	public User getUser(String email, String password) {
		return users.login(email, password);
	}

	@Override
	public int getUserId(String email) {
		return users.getUserId(email);
	}

	@Override
	public boolean isUserValid(String email, String password) {
		if (getUsers().login(email, password) != null) {
			return true;
		}
		return false;
	}

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

	@Override
	public void addUser(User user) {
		int id = users.getUsers().size() + 1;
		user.setId(id);
		if (checkUser(user)) {
			users.addUser(user);
			setUsers(users);
		}
	}

	public boolean checkUser(User user) {
		if ((isValidEmail(user.getEmail()))
				&& (isValidName(user.getFirstName()))
				&& (isValidName(user.getLastName()))
				&& (isValidPassword(user.getPassword()))
				&& (isCorrectRole(user.getRole())) && (isValidId(user.getId()))) {
			return true;
		}
		System.out.println("Fail");
		return false;
	}

	public boolean isValidEmail(String email) {
		String regex = ".*@.*\\.(com|gov|org|net|edu)\\.?.*";
		if (email.matches(regex))
			return true;
		return false;
	}

	// Validation Rule: Must contain valid letters
	public boolean isValidName(String name) {
		String regex = "[a-z]*";
		if (name.matches(regex))
			return true;
		return false;
	}

	// Validation Rule: any lower or upper case letter or any digits
	public boolean isValidPassword(String password) {
		String regex = "[a-zA-Z0-9]*";
		if (password.matches(regex))
			return true;
		return false;
	}

	public boolean isCorrectRole(String role) {
		if (role.equals("Driver") || role.equals("Administrator")) {
			return true;
		}
		return false;
	}

	public boolean isValidId(int id) {

		if (id >= 0)
			return true;
		return false;
	}
}
