package wsd.soap.client;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

import wsd.vms.Trip;

public class TripsSoapClient {
	public static void main(String[] args) {
		TripsSoapServiceLocator locator = new TripsSoapServiceLocator();
		try {
			TripsSoap diary = locator.getTripsSoapPort();

			boolean valid = true;
			while (valid) {
				try {
					String test = diary.fetchTripsList();
					System.out.println(test);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Scanner in = new Scanner(System.in);
				System.out.print("Enter user choice (quit or delete): ");
				String email = in.nextLine();

				if (email.equals("quit")) {

					valid = false;
				} else if (email.equals("delete")) {

					System.out.print("Enter trip id: ");
					int id = Integer.parseInt(in.nextLine());
					try {
						diary.deleteTrip(id);
						System.out.println("Trip deleted");
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** Insert your code here **/
	}
}