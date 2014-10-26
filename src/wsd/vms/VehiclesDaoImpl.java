package wsd.vms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

public class VehiclesDaoImpl implements IVehiclesDao, Serializable {

	private XMLService xmlService;
	private Vehicles vehicles;

	public VehiclesDaoImpl() {
		xmlService = new XMLService();
	}

	public VehiclesDaoImpl(XMLService xmlService) throws JAXBException,
			IOException {
		super();
		this.xmlService = xmlService;
		vehicles = xmlService.unmarshallVehicles();
	}

	@Override
	public Vehicles getVehicles() {
		return vehicles;
	}

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

	@Override
	public ArrayList<Trip> getTrips() {
		return vehicles.getTrips();
	}

	@Override
	public ArrayList<Trip> getTrips(String vehicleRego, int startDate,
			String keyword) {
		ArrayList<Trip> trips = vehicles.getTrips();
		// boolean value to indicate return all trips if no single one trip
		// matches criteria
		boolean allNull = true;
		for (int i = 0; i < trips.size(); i++) {
			// maybe isMatch better than detele here to flag dismatched trips
			boolean delete = false;
			if (vehicleRego != null) {
				allNull = false;
				if (!trips.get(i).getRegoNumber().equals(vehicleRego)) {
					delete = true;
				}
			}
			if (startDate != 0) {
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

	public boolean isNotNull(String value) {
		if(value == null || value.equals(""))
			return false;
		return true;

	}

	public boolean isValidKilometres(double kilometres) {
		if (kilometres >= 0)
			return true;
		return false;
	}

	public boolean isValidId(int id) {
		if (id >= 0)
			return true;
		return false;
	}

	public boolean checkTrip(Trip trip) {
		if (isNotNull(trip.getDriverName()) && (isNotNull(trip.getStartDate()))
				&& (isNotNull(trip.getStartTime()))
				&& (isNotNull(trip.getEndDate()))
				&& (isNotNull(trip.getEndTime()))
				&& (isNotNull(trip.getRegoNumber()))
				&& (isNotNull(trip.getDescription()))
				&& (isValidKilometres(trip.getKilometres()))
				&& (isValidId(trip.getId()))
				&& (!trip.isDeleted())) {
			return true;
		}
		return false;
	}
}
