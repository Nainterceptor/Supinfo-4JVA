/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.web.service.rest;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nainterceptor
 */
@Stateless
@Path("/trips")
@Produces(MediaType.APPLICATION_JSON)
public class TripResource {
    
    @EJB
    private TripService tripService;
    
    @GET
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
}