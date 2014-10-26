package wsd.vms;


public interface IUsersDao {
	
	//retrieve users object from data source
	public Users getUsers();
	
	//retrieve a singel user
	public User getUser(String email, String password);
	
	public int getUserId(String email);
	
	//check if user email matches password when try to login
	public boolean isUserValid(String email, String password);
	
	//replace the whole users in data source with the input
	public void setUsers(Users users);
	
	//add a new user into data source
	public void addUser(User user);

}
