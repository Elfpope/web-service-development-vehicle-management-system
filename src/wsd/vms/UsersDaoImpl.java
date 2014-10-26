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
	
	public UsersDaoImpl(XMLService xmlService) throws JAXBException, IOException {
		this.xmlService = xmlService;
		users = xmlService.unmarshallUsers();
	}

	@Override
	public Users getUsers() {
		return users;
	}

	@Override
	//retrieve a singel user as per credential 
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
	public void setUsers(Users users){
		this.users = users;
		try {
			xmlService.marshallUsers(users);
		} catch (FileNotFoundException e ) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
		int id = users.getUsers().size() + 1;
		user.setId(id);
		users.addUser(user);

		setUsers(users);
	}

}
