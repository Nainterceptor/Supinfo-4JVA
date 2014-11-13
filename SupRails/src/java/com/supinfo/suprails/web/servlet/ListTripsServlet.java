package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.TripService;
import java.io.IOException;
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
    private TripService tripService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Trip> trips = tripService.getAllTrips();
        req.setAttribute("trips", trips);
        req.getRequestDispatcher("/jsp/listTrips.jsp").forward(req, resp);
    }

}
