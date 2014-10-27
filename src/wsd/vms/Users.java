package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

/** users java class containing a list of users */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {
	@XmlElement(name = "user")
	private ArrayList<User> users = new ArrayList<User>();

	/** creates new blank list of users */
	public Users() {
	}

	/** creates list of users */
	public Users(ArrayList<User> users) {
		super();
		this.users = users;
	}

	/** returns list of users */
	public ArrayList<User> getUsers() {
		return users;
	}

	/** sets the list of users */
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	/** adds user to the list */
	public void addUser(User user) {
		users.add(user);
	}

	/**
	 * returns user if the email and password match an existing user. returns
	 * null if it does not exist
	 */
	public User login(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equals(email)
					&& user.getPassword().equals(password))
				return user;
		}
		return null;
	}

	/** returns user ID based on email */
	public int getUserId(String email) {
		for (User user : users) {
			if (user.getEmail().equals(email))
				return user.getId();
		}
		return 0;
	}

	/** returns true if the user exists based on email */
	public boolean userExists(User user) {
		for (User compareUser : users) {
			if (user.getEmail().equals(compareUser.getEmail()))
				return true;
		}
		return false;
	}

}
