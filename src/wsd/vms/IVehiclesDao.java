package wsd.vms;

import java.util.ArrayList;

/** Vehicles DAO interface to deal with all vehicles data CRUD */

public interface IVehiclesDao {

	/** returns the list of vehicles */
	public Vehicles getVehicles();

	/** adds vehicle to the list of vehicles and marshals to XML */
	public void addVehicle(Vehicle vehicle);

	/** returns all trips from all vehicles */
	public ArrayList<Trip> getTrips();

	/** returns list of trips for the REST service based on parameters */
	public ArrayList<Trip> getTrips(String vehicleRego, int startDate, String keyword);

	/** adds trip to the matching vehicle and marshals to XML */
	public void addTrip(Trip trip);

	/** updates existing trip in the list of trips in vehicles as deleted */
	public boolean deleteTrip(int tripId, int userId);

}
