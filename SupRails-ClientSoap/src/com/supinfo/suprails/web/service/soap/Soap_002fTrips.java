
package com.supinfo.suprails.web.service.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "soap/trips", targetNamespace = "http://soap.service.web.suprails.supinfo.com/", wsdlLocation = "http://localhost:8080/SupRails/soap/trips?WSDL")
public class Soap_002fTrips
    extends Service
{

    private final static URL SOAP_002FTRIPS_WSDL_LOCATION;
    private final static WebServiceException SOAP_002FTRIPS_EXCEPTION;
    private final static QName SOAP_002FTRIPS_QNAME = new QName("http://soap.service.web.suprails.supinfo.com/", "soap/trips");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/SupRails/soap/trips?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAP_002FTRIPS_WSDL_LOCATION = url;
        SOAP_002FTRIPS_EXCEPTION = e;
    }

    public Soap_002fTrips() {
        super(__getWsdlLocation(), SOAP_002FTRIPS_QNAME);
    }

    public Soap_002fTrips(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAP_002FTRIPS_QNAME, features);
    }

    public Soap_002fTrips(URL wsdlLocation) {
        super(wsdlLocation, SOAP_002FTRIPS_QNAME);
    }

    public Soap_002fTrips(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAP_002FTRIPS_QNAME, features);
    }

    public Soap_002fTrips(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Soap_002fTrips(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TripResource
     */
    @WebEndpoint(name = "TripResourcePort")
    public TripResource getTripResourcePort() {
        return super.getPort(new QName("http://soap.service.web.suprails.supinfo.com/", "TripResourcePort"), TripResource.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TripResource
     */
    @WebEndpoint(name = "TripResourcePort")
    public TripResource getTripResourcePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.service.web.suprails.supinfo.com/", "TripResourcePort"), TripResource.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAP_002FTRIPS_EXCEPTION!= null) {
            throw SOAP_002FTRIPS_EXCEPTION;
        }
        return SOAP_002FTRIPS_WSDL_LOCATION;
    }

}