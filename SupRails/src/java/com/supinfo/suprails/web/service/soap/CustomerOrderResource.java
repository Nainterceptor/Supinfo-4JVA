/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.web.service.soap;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;
import javax.ejb.EJB;
import javax.jws.WebService;

/**
 *
 * @author nainterceptor
 */
@WebService(serviceName="soap/customerorders")
public class CustomerOrderResource {
    
    @EJB
    private CustomerOrderService customerOrderService;
    
    @EJB
    private TripService tripService;
    
    public boolean create(String firstname, String lastname,
            String email, Long tripId) {
        
        CustomerOrder customerOrder = new CustomerOrder();
        Customer customer = new Customer();
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setEmail(email);
        customerOrder.setCustomer(customer);
        
        Trip trip = tripService.findTripById(tripId);
        if(null == trip) {
            return false;
        }
        
        customerOrder.setTrip(trip);
        
        customerOrderService.processCustomerOrder(customerOrder);
        
        return true;
    }
    
}