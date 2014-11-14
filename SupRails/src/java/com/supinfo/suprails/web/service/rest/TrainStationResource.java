/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.web.service.rest;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.service.TrainStationService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
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
@Path("/trainstations")
@Produces(MediaType.APPLICATION_JSON)
public class TrainStationResource {
    
    @EJB
    private TrainStationService trainStationService;
    
    @GET
    public List<TrainStation> getTrainStations() {
        return trainStationService.getAllTrainStations();
    }
    
    @POST
    @Path("/{name}/{address}/{city}")
    public Response create(@PathParam("name") String name,
                       @PathParam("address") String address,
                       @PathParam("city") String city) {
        
        TrainStation trainStation = new TrainStation();
        trainStation.setName(name);
        trainStation.setAddress(address);
        trainStation.setCity(city);
        
        trainStationService.addTrainStation(trainStation);
        
        return Response.ok().build();
    }
}