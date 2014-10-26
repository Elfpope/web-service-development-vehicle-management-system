package wsd.vms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * XMLService deals with xml file marshaling and unmarshaling.
 * 
 * Benefits: encapsulat all xml file processes to help future code maintain.
 */
public class XMLService implements Serializable {

	private String usersFilePath;
	private String vehiclesFilePath;

	public XMLService() {
	}

	public XMLService(String usersFilePath, String vehiclesFilePath) {
		super();
		this.usersFilePath = usersFilePath;
		this.vehiclesFilePath = vehiclesFilePath;
	}

	public String getUserFilePath() {
		return usersFilePath;
	}

	public String getVehicleFilePath() {
		return vehiclesFilePath;
	}

	public void setUsersFilePath(String usersFilePath) {
		this.usersFilePath = usersFilePath;
	}

	public void setVehiclesFilePath(String vehiclesFilePath) {
		this.vehiclesFilePath = vehiclesFilePath;
	}

	public Users unmarshallUsers() throws JAXBException, IOException {
		Users users = null;
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(usersFilePath);
		users = (Users) u.unmarshal(fin);
		fin.close();
		return users;
	}

	public Vehicles unmarshallVehicles() throws JAXBException, IOException {
		Vehicles vehicles = null;
		JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(vehiclesFilePath);
		vehicles = (Vehicles) u.unmarshal(fin);
		fin.close();
		return vehicles;
	}

	public void marshallUsers(Users users) throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(users, new FileOutputStream(usersFilePath));
	}

	public void marshallVehicles(Vehicles vehicles) throws FileNotFoundException, JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(vehicles, new FileOutputStream(getVehicleFilePath()));
	}

}
