package wsd.vms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

public class VehiclesDaoImpl implements IVehiclesDao, Serializable {
	private static final long serialVersionUID = 1L;
	private XMLService xmlService;
	private Vehicles vehicles;

	/** creates blank vehicle Data access object implementation */
	public VehiclesDaoImpl() {
		xmlService = new XMLService();
	}

	/** creates new vehicles data access object implementation */
	/**
	 * @param usersFilePath File path for users.xml
 	 * @param vehiclesFilePath File path for vehicle.xml
 	 */
	public VehiclesDaoImpl(XMLService xmlService) throws JAXBException,
			IOException {
		super();
		this.xmlService = xmlService;
		vehicles = xmlService.unmarshallVehicles();
	}

	/** returns the list of vehicles */
	@Override
	public Vehicles getVehicles() {
		return vehicles;
	}

	/** adds vehicle to the list of vehicles and marshals to XML */
	@Override
	public void addVehicle(Vehicle vehicle) {
		if (checkVehicle(vehicle)) {
			vehicles.addVehicle(vehicle);
		}
		try {
			xmlService.marshallVehicles(vehicles);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/** returns all trips from all vehicles */
	@Override
	public ArrayList<Trip> getTrips() {
		return vehicles.getTrips();
	}

	/**
	 * returns list of trips for the REST service based on parameters. if
	 * parameter value exists, retrieve the matching trip data and return in a
	 * list of trips
	 */
	@Override
	public ArrayList<Trip> getTrips(String vehicleRego, String startDate,
			String keyword) {
		ArrayList<Trip> trips = vehicles.getTrips();

		// boolean to indicate if parameters were passed. if no parameters were
		// passed, return all trips
		boolean allNull = true;
		for (int i = 0; i < trips.size(); i++) {
			// if trip does not match the required parameter, remove it from
			// the list to be returned
			boolean delete = false;
			if (vehicleRego != null) {
				allNull = false;
				if (!trips.get(i).getRegoNumber().equals(vehicleRego)) {
					delete = true;
				}
			}
			if (startDate != null) {
				allNull = false;
				if (!(trips.get(i).getStartDate().equals(startDate))) {
					delete = true;
				}
			}
			if (keyword != null) {
				allNull = false;
				if (!trips.get(i).getDescription().contains(keyword)) {
					delete = true;
				}
			}
			if (delete) {
				trips.remove(i);
				i--;
			}
		}

		if (allNull) {
			return vehicles.getTrips();
		}
		return trips;
	}

	/** adds trip to the matching vehicle and marshals to XML */
	@Override
	public void addTrip(Trip trip) {
		int id = vehicles.getTripSize() + 1;
		trip.setId(id);
		if (checkTrip(trip)) {
			vehicles.addTrip(trip);
		}
		try {
			xmlService.marshallVehicles(vehicles);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/** updates existing trip in the list of trips in vehicles as deleted */
	@Override
	public boolean deleteTrip(int tripId, int userId) {
		if (vehicles.deleteTrip(tripId, userId)) {
			try {
				xmlService.marshallVehicles(vehicles);
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/** checks vehicle's variables for validity */
	public boolean checkVehicle(Vehicle vehicle) {
		if (isNotNull(vehicle.getRegoNumber())
				&& (isNotNull(vehicle.getType()))
				&& (isNotNull(vehicle.getMake()))
				&& (isNotNull(vehicle.getModel()))
				&& (isNotNull(vehicle.getColour()))
				&& (isValidKilometres(vehicle.getKilometres()))) {
			return true;
		}
		return false;
	}

	/** checks if string is null */
	public boolean isNotNull(String value) {
		if (value == null || value.equals(""))
			return false;
		return true;

	}

	/** kilometre validation: digit higher than 0 */
	public boolean isValidKilometres(double kilometres) {
		if (kilometres >= 0)
			return true;
		return false;
	}

	/** checks trip's variables for validity */
	public boolean checkTrip(Trip trip) {
		if (isNotNull(trip.getDriverName()) && (isNotNull(trip.getStartDate()))
				&& (isNotNull(trip.getStartTime()))
				&& (isNotNull(trip.getEndDate()))
				&& (isNotNull(trip.getEndTime()))
				&& (isNotNull(trip.getRegoNumber()))
				&& (isNotNull(trip.getDescription()))
				&& (isValidKilometres(trip.getKilometres()))
				&& (isValidId(trip.getId())) && (!trip.isDeleted())) {
			return true;
		}
		return false;
	}

	/** trip id validation: digit higher than 0 */
	public boolean isValidId(int id) {
		if (id >= 0)
			return true;
		return false;
	}
}
