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
 
 private VehicleManagementApplication getVehicleApp() throws JAXBException, IOException {
  // The web server can handle requests from different clients in parallel.
  // These are called "threads".
  //
  // We do NOT want other threads to manipulate the application object at the same
  // time that we are manipulating it, otherwise bad things could happen.
  //
  // The "synchronized" keyword is used to lock the application object while
  // we're manpulating it.
  synchronized (application) {
	  VehicleManagementApplication vehicleApp = (VehicleManagementApplication)application.getAttribute("vehicleApp");
   if (vehicleApp == null) {
	   vehicleApp = new VehicleManagementApplication();
	   vehicleApp.setUserPath(application.getRealPath("WEB-INF/users.xml"));
	   vehicleApp.setVehiclePath(application.getRealPath("WEB-INF/vehicles.xml"));
    application.setAttribute("vehicleApp", vehicleApp);
   }
   return vehicleApp;
  }
 }
 @Path("users")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Users getUsers() throws JAXBException, IOException {
	 
	 return getVehicleApp().getUsers();
	 
	}
 @Path("vehicles")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Vehicles getVehicles() throws JAXBException, IOException {
	 
	 return getVehicleApp().getVehicles();
	 
	}
 
 @Path("trips")
 @GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Trip> getTrips(@QueryParam("vehicleRego") String vehicleRego, @QueryParam("startDate") int startDate, @QueryParam("keyword") String keyword ) throws JAXBException, IOException {
		return getVehicleApp().getTrips(vehicleRego, startDate, keyword);
	}
	
 @Path("hello")
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 public String hello() {
  return "Hello World";
 }
 //@Path("users/{email}")
	//@GET
	//@Produces(MediaType.APPLICATION_XML)
	//public User getUser(@PathParam("email") String email) throws JAXBException, IOException {
	// return getVehicleApp().getUser(email);
	//}
 
 //@Path("users")
	//@POST
	//@Consumes(MediaType.APPLICATION_XML)
	//public void addUser(User user) throws JAXBException, IOException {
	 

	// getVehicleApp().addUser( user.getEmail(), user.getName(), user.getPassword(), user.getGender(), user.getFavouriteColour());
	//    }
	  
	
 
 /** YOUR METHODS WILL BE INSERTED HERE **/
}