package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TrainStationService;
import com.supinfo.suprails.service.TripService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bargenson
 */
@WebServlet(urlPatterns="/trips")
public class ListTripsServlet extends HttpServlet {
    @EJB
    private TrainStationService trainStationService;

    @EJB
    private TripService tripService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           
        String departureParam =
                (req.getParameter("departure") != null) ? req.getParameter("departure") : "";
        
        String arrivalParam =
                (req.getParameter("arrival") != null) ? req.getParameter("arrival") : "";
        
        String priceParam =
                (req.getParameter("price") != null) ? req.getParameter("price") : "";
        
        TrainStation departure = null;
        TrainStation arrival = null;
        BigDecimal price = null;
        
        if(!departureParam.isEmpty()) {
            try {
                departure = trainStationService.findTrainStationById(Long.valueOf(departureParam));
            } catch (NumberFormatException e) {
                
            }
        }
            
        if(!arrivalParam.isEmpty()) {
            try {
                arrival = trainStationService.findTrainStationById(Long.valueOf(arrivalParam));
            } catch (NumberFormatException e) {

            }
        }
            
        if(!priceParam.trim().isEmpty()) {
            try {
                price = new BigDecimal(priceParam);
            } catch (NumberFormatException e) {

            }
        }
        
        List<Trip> trips = tripService.getTripsByFilter(departure, arrival, price);
        List<TrainStation> stations = trainStationService.getAllTrainStations();
        
        req.setAttribute("trips", trips);
        req.setAttribute("stations", stations);
        
        req.setAttribute("departure", departureParam);
        req.setAttribute("arrival", arrivalParam);
        req.setAttribute("price", priceParam);
        
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }

}
