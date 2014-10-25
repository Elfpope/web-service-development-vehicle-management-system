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
				
				Scanner in = new Scanner(System.in);
				System.out.print("Enter user choice (showtrips,delete,quit): ");
				String option = in.nextLine();

				if (option.equals("quit")) {
					System.out.println("Application Quit.");
					valid = false;
				} 
				if (option.equals("showtrips")) {
					
					try {
						String test = diary.fetchTripsList();
						System.out.println(test);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				else if (option.equals("delete")) {
					System.out.print("Enter User Email:");
					try {
						String email = in.nextLine();
						int userId = diary.getUserId(email);
						
						if(userId != 0) {
							
							
							System.out.print("Enter trip id: ");
							int tripId = Integer.parseInt(in.nextLine());
							try {
								if (diary.deleteTrip(tripId, userId)) {
								System.out.println("Success: Trip deleted");
								}
								else {
									System.out.println("Error: Trip id not found");
								}
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
					} 
						else {
							System.out.println("Error: Invalid user");
							
						}
					}
						catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					
				}
				System.out.println("");
			}

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** Insert your code here **/
	}
}