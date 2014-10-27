package wsd.soap;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import wsd.vms.Trip;
import wsd.vms.VehicleManagementApplication;

@WebService
public class TripsSoap {

	@Resource
	private WebServiceContext context;

	/** returns all trips */
	@WebMethod
	public String fetchTripsList() {
		try {
			String tripDetailList = "";
			ArrayList<Trip> trips = getVehicleApp().getVehiclesDao().getTrips();
			for (Trip trip : trips) {
				tripDetailList += "Id: " + trip.getId() + "\n";
				tripDetailList += "Registration: " + trip.getRegoNumber() + "\n";
				tripDetailList += "Driver: " + trip.getDriverName() + "\n";
				tripDetailList += "Description: " + trip.getDescription() + "\n";
				tripDetailList += "\n";
			}
			return tripDetailList;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** returns all trips */
	@WebMethod
	public void fetchTrips() {
		try {
			ArrayList<Trip> trips = getVehicleApp().getVehiclesDao().getTrips();
			for (Trip trip : trips) {
				System.out.println("Registration: " + trip.getRegoNumber());
				System.out.println("Driver: " + trip.getDriverName());
				System.out.println("Description: " + trip.getDescription());
				System.out.println();
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** updates existing trip in the list of trips in vehicles as deleted */
	@WebMethod
	public boolean deleteTrip(int tripId, int userId) {
		try {
			if (getVehicleApp().getVehiclesDao().deleteTrip(tripId, userId)) {
				return true;
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/** returns user ID based on email */
	public int getUserId(String email) {
		try {
			return getVehicleApp().getUsersDao().getUserId(email);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/** initialising the vehicle management application */
	private VehicleManagementApplication getVehicleApp() throws JAXBException, IOException {
		ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		synchronized (application) {
			VehicleManagementApplication vehicleApp = (VehicleManagementApplication) application.getAttribute("vehicleApp");
			if (vehicleApp == null) {
				String usersFilePath = application.getRealPath("WEB-INF/users.xml");
				String vehiclesFilePath = application.getRealPath("vehicles.xml");
				vehicleApp = new VehicleManagementApplication(usersFilePath, vehiclesFilePath);

				application.setAttribute("vehicleApp", vehicleApp);
			}
			return vehicleApp;
		}
	}

}