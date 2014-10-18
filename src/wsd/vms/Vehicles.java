package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

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
	}

	public ArrayList<Trip> getTrips() {

		ArrayList<Trip> trips = new ArrayList<Trip>();
		
		for (Vehicle vehicle : vehicles) {
			trips.addAll(vehicle.getTrips());
		}
		return trips;
	}
}
