package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "registrationNumber")
	private String regoNumber;
	@XmlElement(name = "vehicleType")
	private String type;


	@XmlElement(name = "make")
	private String make;
	@XmlElement(name = "model")
	private String model;
	@XmlElement(name = "odometer")
	private double kilometres;
	
	@XmlElement(name = "colour")
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
