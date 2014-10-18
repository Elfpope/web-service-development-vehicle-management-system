package wsd.vms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import wsd.vms.User;
import wsd.vms.Users;

public class VehicleManagementApplication {

	
	private String filePath;
	private Users users;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) throws JAXBException, FileNotFoundException {
		this.filePath = filePath;
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		 
		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		users = (Users)u.unmarshal(fin); // This loads the "shop" object
		try {
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public boolean validUser(String email, String password) {
		
		//if(getUsers().login(email, password) != null) {
			
		//return true;
		//}
		return false;
	}
public User userInfo(String email, String password) {
		
		//return getUsers().login(email, password);
			return null;
	
	}

public User getUser(String email) {
	
	//return getUsers().email(email);
		return null;

}
	public void addUser(int id, String firstName, String lastName, String password,
			String role) throws FileNotFoundException, JAXBException {
		getUsers().addUser(new User(id, firstName, lastName,password,
				role));
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(users, new FileOutputStream(getFilePath()));
	}
	public void setFilePath2(String filePath) throws JAXBException, FileNotFoundException {
		this.filePath = filePath;
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		 
		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		getUsers().addUser((User)u.unmarshal(fin));
		
		try {
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
