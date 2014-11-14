
package com.supinfo.suprails.web.service.soap;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arrivalStation" type="{http://soap.service.web.suprails.supinfo.com/}trainStation" minOccurs="0"/>
 *         &lt;element name="departureStation" type="{http://soap.service.web.suprails.supinfo.com/}trainStation" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trip", propOrder = {
    "arrivalStation",
    "departureStation",
    "id",
    "price"
})
public class Trip {

    protected TrainStation arrivalStation;
    protected TrainStation departureStation;
    protected Long id;
    protected BigDecimal price;

    /**
     * Gets the value of the arrivalStation property.
     * 
     * @return
     *     possible object is
     *     {@link TrainStation }
     *     
     */
    public TrainStation getArrivalStation() {
        return arrivalStation;
    }

    /**
     * Sets the value of the arrivalStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainStation }
     *     
     */
    public void setArrivalStation(TrainStation value) {
        this.arrivalStation = value;
    }

    /**
     * Gets the value of the departureStation property.
     * 
     * @return
     *     possible object is
     *     {@link TrainStation }
     *     
     */
    public TrainStation getDepartureStation() {
        return departureStation;
    }

    /**
     * Sets the value of the departureStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrainStation }
     *     
     */
    public void setDepartureStation(TrainStation value) {
        this.departureStation = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

}
