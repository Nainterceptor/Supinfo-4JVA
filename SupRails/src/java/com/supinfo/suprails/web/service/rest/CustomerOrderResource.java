/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.web.service.rest;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
import com.supinfo.suprails.service.TripService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author nainterceptor
 */
@Stateless
@Path("/customerorders")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerOrderResource {
    
    @EJB
    private CustomerOrderService customerOrderService;
    
    @EJB
    private TripService tripService;
    
    @POST
    @Path("/{firstname}/{lastname}/{email}/{tripId}")
    public Response create(@PathParam("firstname") String firstname,
                       @PathParam("lastname") String lastname,
                       @PathParam("email") String email,
                       @PathParam("tripId") Long tripId) {
        
        CustomerOrder customerOrder = new CustomerOrder();
        Customer customer = new Customer();
        customer.setFirstName(firstname);
        customer.setLastName(lastname);
        customer.setEmail(email);
        customerOrder.setCustomer(customer);
        
        Trip trip = tripService.findTripById(tripId);
        if(null == trip) {
            return Response.status(404).build();
        }
        
        customerOrder.setTrip(trip);
        
        customerOrderService.processCustomerOrder(customerOrder);
        
        return Response.ok().build();
    }
    
}