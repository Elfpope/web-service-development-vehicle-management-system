package wsd.vms;

/** Users DAO interface to deal with all users data CRUD */

public interface IUsersDao {

	/** returns the list of users */
	public Users getUsers();

	/** returns a user based on email and password */
	public User getUser(String email, String password);

	/** returns user ID based on email */
	public int getUserId(String email);

	/** adds user object to list of users */
	public void addUser(User user);
	
	/** sets the users by marshaling XML */
	public void setUsers(Users users);

}
