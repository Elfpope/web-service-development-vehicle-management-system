package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

public class Vehicle implements Serializable {
	private String regoNumber;
	private String type;
	private double kilometres;
	private String make;
	private String model;
	private String colour;
	private ArrayList<Trip> trips = new ArrayList<Trip> ();
	
	public Vehicle() {	}

	public Vehicle(String regoNumber, String type, double kilometres,
			String make, String model, String colour) {
		super();
		this.regoNumber = regoNumber;
		this.type = type;
		this.kilometres = kilometres;
		this.make = make;
		this.model = model;
		this.colour = colour;
	}

	public String getRegoNumber() {
		return regoNumber;
	}

	public void setRegoNumber(String regoNumber) {
		this.regoNumber = regoNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getKilometres() {
		return kilometres;
	}

	public void setKilometres(double kilometres) {
		this.kilometres = kilometres;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}
	
	

}
