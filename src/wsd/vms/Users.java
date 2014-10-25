package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {
	@XmlElement(name = "user")
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
	
	public void addUser(User user) {
		
		users.add(user);
	}
	  public User login(String email, String password) {
	        // For each user in the list...
	        for (User user : users) {
	            if (user.getEmail().equals(email) && user.getPassword().equals(password))
	                return user; // Login correct. Return this user.
	        }
	        return null; // Login incorrect. Return null.
	    }
	  public int getUserId(String email) {
		  for (User user : users) {
	            if (user.getEmail().equals(email))
	                return user.getId(); // Login correct. Return this user.
	        }
	        return 0; // Login incorrect. Return null.
	  
	  }


	
		
}
