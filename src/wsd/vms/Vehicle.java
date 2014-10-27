package wsd.vms;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** vehicle java class containing a list of trips */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicle implements Serializable, Comparable<Vehicle> {
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "regoNumber")
	private String regoNumber;
	@XmlElement(name = "vehicleType")
	private String type;
	@XmlElement(name = "make")
	private String make;
	@XmlElement(name = "model")
	private String model;
	@XmlElement(name = "colour")
	private String colour;
	@XmlElement(name = "kilometres")
	private double kilometres;
	@XmlElement(name = "trip")
	private ArrayList<Trip> trips = new ArrayList<Trip>();

	/** creates new blank vehicle */
	public Vehicle() {
	}

	/** creates new vehicle */
	/**
	 * @param regoNumber Registration number of the vehicle
	 * @param type Type of vehicle
	 * @param make Make of vehicle
	 * @param model Model of vehicle
	 * @param colour Colour of vehicle
	 * @param kilometres Accumulative kilometres travelled
	 */
	public Vehicle(String regoNumber, String type, String make, String model,
			String colour, double kilometres) {
		super();
		this.regoNumber = regoNumber;
		this.type = type;
		this.make = make;
		this.model = model;
		this.colour = colour;
		this.kilometres = kilometres;
	}

	/** returns registration number */
	public String getRegoNumber() {
		return regoNumber;
	}

	/** sets the registration number */
	public void setRegoNumber(String regoNumber) {
		this.regoNumber = regoNumber;
	}

	/** returns the vehicle type */
	public String getType() {
		return type;
	}

	/** sets the vehicle type */
	public void setType(String type) {
		this.type = type;
	}

	/** returns the vehicle make */
	public String getMake() {
		return make;
	}

	/** sets the make */
	public void setMake(String make) {
		this.make = make;
	}

	/** returns the vehicle model */
	public String getModel() {
		return model;
	}

	/** sets the model */
	public void setModel(String model) {
		this.model = model;
	}

	/** returns the colour */
	public String getColour() {
		return colour;
	}

	/** sets the colour */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/** returns the accumulative kilometres travelled */
	public double getKilometres() {
		return kilometres;
	}

	/** sets the accumulative kilometres travelled */
	public void setKilometres(double kilometres) {
		this.kilometres = kilometres;
	}

	/** returns the list of trips */
	public ArrayList<Trip> getTrips() {
		ArrayList<Trip> currentTrips = new ArrayList<Trip>();
		for (Trip trip : trips) {
			if (!trip.isDeleted()) {
				currentTrips.add(trip);
			}
		}
		return currentTrips;
	}

	/** sets the list of trips */
	public void setTrips(ArrayList<Trip> trips) {
		this.trips = trips;
	}

	/** returns the number of trips in trips list */
	public int getTripsSize() {
		return trips.size();
	}

	/**
	 * adds new trip to the list of trips then updates accumulative kilometres
	 * travelled
	 */
	public void addTrips(Trip trip) {
		trips.add(trip);
		kilometres += trip.getKilometres();
	}

	/**
	 * updates existing trip in the list of trips as deleted and records user ID
	 * then updates accumulative kilometres travelled
	 */
	public boolean deleteTrip(int tripId, int userId) {
		for (Trip trip : trips) {
			if (!trip.isDeleted() && trip.getId() == tripId) {
				trip.setDeleted(true);
				trip.setDeletedById(userId);
				kilometres -= trip.getKilometres();
				return true;
			}
		}
		return false;
	}

	/** comparison to allow vehicles to be sorted */
	@Override
	public int compareTo(Vehicle compareVehicle) {
		int compareResult = regoNumber.compareTo(((Vehicle) compareVehicle)
				.getRegoNumber());
		return compareResult;
	}

}
