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
 * XMLService deals with XML file marshaling and unmarshaling.
 */
public class XMLService implements Serializable {

	private String usersFilePath;
	private String vehiclesFilePath;

	/** creates new blank XML service */
	public XMLService() {
	}

	/** creates new XML service */
	public XMLService(String usersFilePath, String vehiclesFilePath) {
		super();
		this.usersFilePath = usersFilePath;
		this.vehiclesFilePath = vehiclesFilePath;
	}

	/** returns user XML file path */
	public String getUserFilePath() {
		return usersFilePath;
	}

	/** sets user XML file path */
	public void setUsersFilePath(String usersFilePath) {
		this.usersFilePath = usersFilePath;
	}

	/** returns vehicle XML file path */
	public String getVehicleFilePath() {
		return vehiclesFilePath;
	}

	/** return vehicle XML file path */
	public void setVehiclesFilePath(String vehiclesFilePath) {
		this.vehiclesFilePath = vehiclesFilePath;
	}

	/** unmarshals users from user XML */
	public Users unmarshallUsers() throws JAXBException, IOException {
		Users users = null;
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(usersFilePath);
		users = (Users) u.unmarshal(fin);
		fin.close();
		return users;
	}

	/** unmarshals vehicles from vehicle XML */
	public Vehicles unmarshallVehicles() throws JAXBException, IOException {
		Vehicles vehicles = null;
		JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(vehiclesFilePath);
		vehicles = (Vehicles) u.unmarshal(fin);
		fin.close();
		return vehicles;
	}

	/** marshals users to user XML */
	public void marshallUsers(Users users) throws JAXBException, FileNotFoundException {
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(users, new FileOutputStream(usersFilePath));
		m.marshal(users, new
				 FileOutputStream("C:/Users/Rebecca Ao/Desktop/31284/New folder (2)/WebContent/WEB-INF/users.xml"));
	}

	/** marshals vehicles to vehicle XML */
	public void marshallVehicles(Vehicles vehicles) throws FileNotFoundException, JAXBException {
		JAXBContext jc = JAXBContext.newInstance(Vehicles.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(vehicles, new FileOutputStream(getVehicleFilePath()));
		m.marshal(vehicles, new
				 FileOutputStream("C:/Users/Rebecca Ao/Desktop/31284/New folder (2)/WebContent/vehicles.xml"));
	}

}
