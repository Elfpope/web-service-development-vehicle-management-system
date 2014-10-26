package wsd.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;

import wsd.vms.Trip;
import wsd.vms.Users;
import wsd.vms.VehicleManagementApplication;
import wsd.vms.Vehicles;

import java.io.*;
import java.util.ArrayList;

@Path("/vehicleApp")
public class TripsService {
	@Context
	private ServletContext application;

	private VehicleManagementApplication getVehicleApp() throws JAXBException,
			IOException {

		synchronized (application) {
			VehicleManagementApplication vehicleApp = (VehicleManagementApplication) application
					.getAttribute("vehicleApp");
			if (vehicleApp == null) {
				String usersFilePath = application
						.getRealPath("WEB-INF/users.xml");
				String vehiclesFilePath = application
						.getRealPath("vehicles.xml");
				vehicleApp = new VehicleManagementApplication(usersFilePath,
						vehiclesFilePath);
				application.setAttribute("vehicleApp", vehicleApp);
			}
			return vehicleApp;
		}
	}

	@Path("users")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Users getUsers() throws JAXBException, IOException {
		return getVehicleApp().getUsersDao().getUsers();
	}

	@Path("vehicles")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Vehicles getVehicles() throws JAXBException, IOException {
		return getVehicleApp().getVehiclesDao().getVehicles();
	}

	@Path("trips")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Trip> getTrips(
			@QueryParam("regoNumber") String vehicleRego,
			@QueryParam("startDate") int startDate,
			@QueryParam("keyword") String keyword) throws JAXBException,
			IOException {
		return getVehicleApp().getVehiclesDao().getTrips(vehicleRego,
				startDate, keyword);
	}
}