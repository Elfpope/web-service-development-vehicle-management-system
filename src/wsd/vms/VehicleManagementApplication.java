package wsd.vms;

import java.io.IOException;

import javax.xml.bind.JAXBException;

public class VehicleManagementApplication {

	private IUsersDao usersDao;
	private IVehiclesDao vehiclesDao;
	private XMLService xmlService;

	public VehicleManagementApplication() {
		super();
	}

	public VehicleManagementApplication(String usersFilePath,
			String vehiclesFilePath) throws JAXBException, IOException {
		super();
		xmlService = new XMLService(usersFilePath, vehiclesFilePath);
		usersDao = new UsersDaoImpl(xmlService);
		vehiclesDao = new VehiclesDaoImpl(xmlService);
	}

	public IUsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(IUsersDao usersDaoImpl) {
		this.usersDao = usersDaoImpl;
	}

	public IVehiclesDao getVehiclesDao() {
		return vehiclesDao;
	}

	public void setVehiclesDao(IVehiclesDao vehiclesDao) {
		this.vehiclesDao = vehiclesDao;
	}

	public XMLService getXmlService() {
		return xmlService;
	}

	public void setXmlService(XMLService xmlService) {
		this.xmlService = xmlService;
	}
}
