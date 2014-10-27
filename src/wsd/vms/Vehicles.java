package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** vehicles java class containing a list of vehicles */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "vehicles")
public class Vehicles implements Serializable {
	@XmlElement(name = "vehicle")
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	/** creates new list of vehicles */
	public Vehicles() {
	}

	/** returns list of vehicles */
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	/** sets list of vehicles */
	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
		sort();
	}

	/** sorts vehicles in the list of vehicles */
	public void sort() {
		Collections.sort(vehicles);
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.getRegoNumber());
		}
	}

	/** returns all trips from all vehicles */
	public ArrayList<Trip> getTrips() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		for (Vehicle vehicle : vehicles) {
			trips.addAll(vehicle.getTrips());
		}
		return trips;
	}

	/** adds vehicle to the list then sorts by registration number */
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		sort();
	}

	/** adds trip to vehicle in the list of vehicles */
	public void addTrip(Trip trip) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getRegoNumber().equals(trip.getRegoNumber())) {
				vehicle.addTrips(trip);
			}
		}
	}

	/** updates existing trip in the list of trips in vehicles as deleted */
	public boolean deleteTrip(int tripId, int userId) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.deleteTrip(tripId, userId)) {
				return true;
			}
		}
		return false;
	}

	/** returns total number of trips */
	public int getTripSize() {
		int size = 0;
		for (Vehicle vehicle : vehicles) {
			size += vehicle.getTripsSize();
		}
		return size;
	}

	/** returns true if vehicle registration number exists in list */
	public boolean vehicleExists(Vehicle vehicle) {
		for (Vehicle vehicle2 : vehicles) {
			if (vehicle.getRegoNumber().equals(vehicle2.getRegoNumber()))
				return true;
		}
		return false;
	}
}
