package wsd.soap.client;

public class TripsSoapProxy implements wsd.soap.client.TripsSoap {
  private String _endpoint = null;
  private wsd.soap.client.TripsSoap tripsSoap = null;
  
  public TripsSoapProxy() {
    _initTripsSoapProxy();
  }
  
  public TripsSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initTripsSoapProxy();
  }
  
  private void _initTripsSoapProxy() {
    try {
      tripsSoap = (new wsd.soap.client.TripsSoapServiceLocator()).getTripsSoapPort();
      if (tripsSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tripsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tripsSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tripsSoap != null)
      ((javax.xml.rpc.Stub)tripsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wsd.soap.client.TripsSoap getTripsSoap() {
    if (tripsSoap == null)
      _initTripsSoapProxy();
    return tripsSoap;
  }
  
  public void fetchTrips() throws java.rmi.RemoteException{
    if (tripsSoap == null)
      _initTripsSoapProxy();
    tripsSoap.fetchTrips();
  }
  
  public boolean deleteTrip(int arg0, int arg1) throws java.rmi.RemoteException{
    if (tripsSoap == null)
      _initTripsSoapProxy();
    return tripsSoap.deleteTrip(arg0, arg1);
  }
  
  public int getUserId(java.lang.String arg0) throws java.rmi.RemoteException{
    if (tripsSoap == null)
      _initTripsSoapProxy();
    return tripsSoap.getUserId(arg0);
  }
  
  public java.lang.String fetchTripsList() throws java.rmi.RemoteException{
    if (tripsSoap == null)
      _initTripsSoapProxy();
    return tripsSoap.fetchTripsList();
  }
  
  
}