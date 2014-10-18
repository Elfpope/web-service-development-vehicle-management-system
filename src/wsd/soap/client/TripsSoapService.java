/**
 * TripsSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wsd.soap.client;

public interface TripsSoapService extends javax.xml.rpc.Service {
    public java.lang.String getTripsSoapPortAddress();

    public wsd.soap.client.TripsSoap getTripsSoapPort() throws javax.xml.rpc.ServiceException;

    public wsd.soap.client.TripsSoap getTripsSoapPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
