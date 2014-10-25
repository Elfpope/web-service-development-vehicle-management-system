package wsd.vms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import wsd.vms.User;
import wsd.vms.Users;

public class VehicleManagementApplication {

	private String usersFilePath;
	private String vehiclesFilePath;
	private Users users;
	private Vehicles vehicles;

	public String getUserFilePath() {
		return usersFilePath;
	}
	
	public String getVehicleFilePath() {
		return vehiclesFilePath;
	}
	
	public void setUsersFilePath(String usersFilePath) throws JAXBException, IOException {
		this.usersFilePath = usersFilePath;
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();

		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(usersFilePath);
		users = (Users) u.unmarshal(fin); 
		fin.close();
	}
	
	public void setVehiclesFilePath(String vehiclesFilePath) throws JAXBException, IOException {
		this.vehiclesFilePath = vehiclesFilePath;
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		Unmarshaller u = jc.createUnmarshaller();

		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(vehiclesFilePath);
		vehicles = (Vehicles) u.unmarshal(fin); 
		fin.close();
	}

	public Users getUsers() {
		return users;
	}

	public Vehicles getVehicles() {
		return vehicles;
	}

	public ArrayList<Trip> getTrips() {
		return vehicles.getTrips();
	}

	public ArrayList<Trip> getTrips(String vehicleRego, int startDate, String keyword) {
		ArrayList<Trip> trips = vehicles.getTrips();
		//boolean value to indicate return all trips if no single one trip matches criteria
		boolean allNull = true;

		for (int i = 0; i < trips.size(); i++) {
			//maybe isMatch better than detele here to flag dismatched trips
			boolean delete = false;
			if (vehicleRego != null) {
				allNull = false;
				if (!trips.get(i).getRegoNumber().equals(vehicleRego)) {
					delete = true;
				}
			}
			if (startDate != 0) {
				allNull = false;
				if (!(trips.get(i).getStratDate() == startDate)) {
					delete = true;
				}
			}
			if (keyword != null) {
				allNull = false;
				if (!trips.get(i).getDescripton().contains(keyword)) {
					delete = true;
				}
			}
			if (delete) {
				trips.remove(i);
				i--;
			}
		}

		if (allNull) {
			return vehicles.getTrips();
		}
		return trips;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public boolean isValidUser(String email, String password) {
		if (users.login(email, password) != null) {
			return true;
		}
		return false;
	}

	public User getUser(String email, String password) {
		return users.login(email, password);
	}
	
	public void addUser(User user) throws FileNotFoundException, JAXBException {
		users.addUser(user);
		marshallUsers();
	}

	public void marshallVehicles() throws FileNotFoundException, JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		m.marshal(vehicles, new FileOutputStream(getVehicleFilePath()));
		//m.marshal(vehicles, new FileOutputStream("C:/Users/Rebecca Ao/Desktop/31284/New folder (2)/WebContent/vehicles.xml"));
		// JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		// Marshaller m = jc.createMarshaller();
		// m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// m.marshal(vehicles, new FileOutputStream("WEB-INF/vehicles.xml"));
	}
	
	public void marshallUsers() throws JAXBException, FileNotFoundException{
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();				
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(users, new FileOutputStream(usersFilePath));
		//m.marshal(users, new FileOutputStream("C:/Users/Rebecca Ao/Desktop/31284/New folder (2)/WebContent/WEB-INF/users.xml"));
	}

	public void deleteTrip(int tripId, int userId) {
		vehicles.deleteTrip(tripId, userId);
		try {
			marshallVehicles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	//Validation Rule: must have "@" and "com|gov|org|net|edu"
	public boolean isEmailValid(String email){
		String regex = ".*@.*\\.(com|gov|org|net|edu).*";
		if (email.matches(regex))
			return true;		
		return false;
	}
	
	//Validation Rule: First letter must be capital.
	public boolean isNameValid(String name){
		String regex = "[A-Z][a-z]*";
		if (name.matches(regex))
			return true;		
		return false;
	}
	
	//Validation Rule: any lower or upper case letter or any digits
	public boolean isPasswordValid(String password){
		String regex = "([a-zA-Z0-9]){4,16}";
		if (password.matches(regex))
			return true;		
		return false;
	}

	public boolean isconfirmPasswordSame(String password, String confirmPassword){
		if (password.equals(confirmPassword))
			return true;		
		return false;
	}
}
