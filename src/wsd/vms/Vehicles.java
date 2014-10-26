package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "vehicles")
public class Vehicles implements Serializable {
	@XmlElement(name = "vehicle")
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	public Vehicles() {
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
		sort();
	}

	public void sort() {
		Collections.sort(vehicles);
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle.getRegoNumber());
		}
	}

	public ArrayList<Trip> getTrips() {
		ArrayList<Trip> trips = new ArrayList<Trip>();
		for (Vehicle vehicle : vehicles) {
			trips.addAll(vehicle.getTrips());
		}
		return trips;
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		sort();
	}

	public void addTrip(Trip trip) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getRegoNumber().equals(trip.getRegoNumber())) {
				vehicle.addTrips(trip);
			}
		}
	}

	public boolean deleteTrip(int tripId, int userId) {
		for (Vehicle vehicle : vehicles) {
			if (vehicle.deleteTrip(tripId, userId)) {
				return true;
			}
		}
		return false;
	}

	public int getTripSize() {
		int size = 0;
		for (Vehicle vehicle : vehicles) {
			size += vehicle.getTripsSize();
		}
		return size;
	}

	public boolean vehicleExists(Vehicle vehicle) {
		for (Vehicle vehicle2 : vehicles) {
			if (vehicle.getRegoNumber().equals(vehicle2.getRegoNumber()))
				return true;
		}
		return false;
	}
}
