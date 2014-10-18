/**
 * TripsSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsd.soap.client;

public interface TripsSoap extends java.rmi.Remote {
    public java.lang.String fetchTripsList() throws java.rmi.RemoteException;
    public void fetchTrips() throws java.rmi.RemoteException;
    public void deleteTrip(int arg0) throws java.rmi.RemoteException;
    public int add(int arg0, int arg1) throws java.rmi.RemoteException;
}
