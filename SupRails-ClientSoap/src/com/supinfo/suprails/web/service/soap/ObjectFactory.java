
package com.supinfo.suprails.web.service.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.supinfo.suprails.web.service.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _All_QNAME = new QName("http://soap.service.web.suprails.supinfo.com/", "all");
    private final static QName _AllResponse_QNAME = new QName("http://soap.service.web.suprails.supinfo.com/", "allResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.supinfo.suprails.web.service.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link All }
     * 
     */
    public All createAll() {
        return new All();
    }

    /**
     * Create an instance of {@link AllResponse }
     * 
     */
    public AllResponse createAllResponse() {
        return new AllResponse();
    }

    /**
     * Create an instance of {@link Trip }
     * 
     */
    public Trip createTrip() {
        return new Trip();
    }

    /**
     * Create an instance of {@link TrainStation }
     * 
     */
    public TrainStation createTrainStation() {
        return new TrainStation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link All }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.web.suprails.supinfo.com/", name = "all")
    public JAXBElement<All> createAll(All value) {
        return new JAXBElement<All>(_All_QNAME, All.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.web.suprails.supinfo.com/", name = "allResponse")
    public JAXBElement<AllResponse> createAllResponse(AllResponse value) {
        return new JAXBElement<AllResponse>(_AllResponse_QNAME, AllResponse.class, null, value);
    }

}
