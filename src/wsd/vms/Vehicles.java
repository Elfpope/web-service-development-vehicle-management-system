package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehicles implements Serializable {
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public Vehicles() {	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
