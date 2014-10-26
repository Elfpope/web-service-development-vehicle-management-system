package wsd.vms;

/**
 * Users Dao interface deals with all users data CRUD.
 */

public interface IUsersDao {
	
	//retrieve the users object from the data source
	public Users getUsers();
	
	//retrieves a single user
	public User getUser(String email, String password);
	
	//retrieves a single user id
	public int getUserId(String email);
	
	//checks if the users email and password matches for login
	public boolean isUserValid(String email, String password);
	
	//replaces the users list with input from a data source
	public void setUsers(Users users);
	
	//adds a new user into the data source
	public void addUser(User user);

}
