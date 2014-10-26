package wsd.vms;

import java.util.ArrayList;

/**
 * Vehicles Dao interface deals with all vehicles data CRUD.
 */

public interface IVehiclesDao {
	
	//retrieve all vehicles from the data source
	 public Vehicles getVehicles();
	 
	//adds a new vehicle into the data source
	 public void addVehicle(Vehicle vehicle);
	 
	//retrieve all trips from the data source
	 public ArrayList<Trip> getTrips();
	 
	//retrieve the trips object from the data source as per criteria
	 public ArrayList<Trip> getTrips(String vehicleRego, int startDate, String keyword);
	 
	//adds a new trip into the data source
	 public void addTrip(Trip trip);
	 
	 //flap a trip as deleted
	 public boolean deleteTrip(int tripId, int userId);

}
