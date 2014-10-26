package wsd.vms;

import java.util.ArrayList;

public interface IVehiclesDao {
	
	 public Vehicles getVehicles();
	 
	 public void addVehicle(Vehicle vehicle);
	 
	 public ArrayList<Trip> getTrips();
	 
	 public ArrayList<Trip> getTrips(String vehicleRego, int startDate, String keyword);
	 
	 public void addTrip(Trip trip);
	 
	 public boolean deleteTrip(int tripId, int userId);

}
