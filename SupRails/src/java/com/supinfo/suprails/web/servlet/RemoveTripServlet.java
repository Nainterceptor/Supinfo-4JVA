/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.service.TripService;
import java.io.IOException;
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
@WebServlet(name = "RemoveTripServlet", urlPatterns = {"/admin/trips/delete"})
public class RemoveTripServlet extends HttpServlet {
    
    @EJB
    private TripService tripService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Long tripId = Long.valueOf(idParam);
        
        tripService.removeTrip(tripId);
        
        resp.sendRedirect(getServletContext().getContextPath() + "/trips");
    }
    
}
