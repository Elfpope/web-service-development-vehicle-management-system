package wsd.vms;

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

	private String filePath;
	private Users users;
	private Vehicles vehicles;

	public String getFilePath() {
		return filePath;
	}

	public void setUserPath(String filePath) throws JAXBException,
			FileNotFoundException {
		this.filePath = filePath;
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();

		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		users = (Users) u.unmarshal(fin); // This loads the "shop" object
		try {
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setVehiclePath(String filePath) throws JAXBException,
			FileNotFoundException {
		this.filePath = filePath;
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		Unmarshaller u = jc.createUnmarshaller();

		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		vehicles = (Vehicles) u.unmarshal(fin); // This loads the "shop" object
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

	public Vehicles getVehicles() {
		return vehicles;
	}

	public ArrayList<Trip> getTrips() {
		return vehicles.getTrips();
	}

	public ArrayList<Trip> getTrips(String vehicleRego, int startDate,
			String keyword) {

		ArrayList<Trip> trips = vehicles.getTrips();
		boolean allNull = true;

		for (int i = 0; i < trips.size(); i++) {
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

	public boolean isValidUser(String id, String password) {

		if (getUsers().login(id, password) != null) {

			return true;
		}
		return false;
	}

	public User getUser(String id, String password) {
		System.out.println("HELLO" + id + password);
		Users users = getUsers();
		User poo = users.login(id, password);
		return poo;

	}

	public void addUser(String id, String firstName, String lastName,
			String password, String role) throws FileNotFoundException,
			JAXBException {
		getUsers().addUser(new User(id, firstName, lastName, password, role));
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(users, new FileOutputStream(getFilePath()));
	}

	public void setFilePath2(String filePath) throws JAXBException,
			FileNotFoundException {
		this.filePath = filePath;
		// Create the unmarshaller
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();

		// Now unmarshal the object from the file
		FileInputStream fin = new FileInputStream(filePath);
		getUsers().addUser((User) u.unmarshal(fin));

		try {
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
