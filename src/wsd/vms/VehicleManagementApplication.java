package wsd.vms;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public class VehicleManagementApplication {

	private IUsersDao usersDao;
	private IVehiclesDao vehiclesDao;
	private XMLService xmlService;

	/** creates new blank vehicle management application */
	public VehicleManagementApplication() {
		super();
	}

	/** creates new vehicle management application with user and vehicle XML's */
	public VehicleManagementApplication(String usersFilePath,
			String vehiclesFilePath) throws JAXBException, IOException {
		super();
		xmlService = new XMLService(usersFilePath, vehiclesFilePath);
		usersDao = new UsersDaoImpl(xmlService);
		vehiclesDao = new VehiclesDaoImpl(xmlService);
	}

	/** returns the users data access object */
	public IUsersDao getUsersDao() {
		return usersDao;
	}

	/** sets the users data access object */
	public void setUsersDao(IUsersDao usersDaoImpl) {
		this.usersDao = usersDaoImpl;
	}

	/** returns the vehicles data access object */
	public IVehiclesDao getVehiclesDao() {
		return vehiclesDao;
	}

	/** sets the vehicles data access object */
	public void setVehiclesDao(IVehiclesDao vehiclesDao) {
		this.vehiclesDao = vehiclesDao;
	}

	/** returns the XML service */
	public XMLService getXmlService() {
		return xmlService;
	}

	/** sets the XML service */
	public void setXmlService(XMLService xmlService) {
		this.xmlService = xmlService;
	}
}
