package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {
	private ArrayList<User> users = new ArrayList<User>();
	
	public Users() {}

	public Users(ArrayList<User> users) {
		super();
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}	

}
