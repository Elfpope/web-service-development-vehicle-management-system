package wsd.soap.client;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

public class TripsSoapClient {
	/** SOAP client initiator */
	public static void main(String[] args) {
		TripsSoapServiceLocator locator = new TripsSoapServiceLocator();
		TripsSoap vehicleApp;
		try {
			vehicleApp = locator.getTripsSoapPort();

			boolean valid = true;
			while (valid) {
				Scanner in = new Scanner(System.in);
				System.out.print("Enter user choice (showtrips,delete,quit): ");
				String option = in.nextLine();
				if (option.equals("quit")) {
					valid = false;
					System.out.println("Application Quit.");
				} else if (option.equals("showtrips")) {
					showTripsOption(vehicleApp);
				} else if (option.equals("delete")) {
					deleteOption(vehicleApp);
				} else {
					System.out
							.println("  Invalid Option entered. Valid options are:");
					System.out
							.println("\tshowtrips - Displays a list of current trips");
					System.out
							.println("\tdelete - Delete a trip using the client interface");
					System.out
							.println("\tquit - quit the current client session");
				}
				System.out.println("");
			}

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	/** show options for trips */
	public static void showTripsOption(TripsSoap vehicleApp) {
		try {
			String tripsDetailList = vehicleApp.fetchTripsList();
			System.out.println(tripsDetailList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/** show delete options for trips */
	public static void deleteOption(TripsSoap vehicleApp) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter User Email:");
		try {
			String email = in.nextLine();
			int userId = vehicleApp.getUserId(email);
			if (userId != 0) {
				deleteTrip(vehicleApp, userId);

			} else {
				System.out.println("Error: Invalid user");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	/** show options for trips */
	public static void deleteTrip(TripsSoap vehicleApp, int userId) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter trip id: ");
		int tripId = Integer.parseInt(in.nextLine());
		try {
			if (vehicleApp.deleteTrip(tripId, userId)) {
				System.out.println("Success: Trip deleted");
			} else {
				System.out.println("Error: Trip id not found");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}