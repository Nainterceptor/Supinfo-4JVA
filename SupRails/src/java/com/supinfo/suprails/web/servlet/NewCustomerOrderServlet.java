/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.service.CustomerOrderService;
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
 * @author nainterceptor
 */
@WebServlet(name = "NewCustomerOrderServlet", urlPatterns = {"/customerorder/new"})
public class NewCustomerOrderServlet extends HttpServlet {
    @EJB
    private TripService tripService;
    
    @EJB
    private CustomerOrderService customerOrderService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Trip trip = null;
        
        try {
            long tripId = Long.valueOf(req.getParameter("id"));
            trip = tripService.findTripById(tripId);
        } catch (Exception e) {
            resp.sendError(404);
            return;
        }
        
        req.setAttribute("trip", trip);
        req.getRequestDispatcher("/jsp/newCustomerOrder.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Trip trip = null;
        
        try {
            long tripId = Long.valueOf(req.getParameter("trip_id"));
            trip = tripService.findTripById(tripId);
        } catch (Exception e) {
            resp.sendError(404);
            return;
        }
        
        CustomerOrder customOrder = new CustomerOrder();
        customOrder.setTrip(trip);
        
        Customer customer = new Customer();
        customer.setFirstName(req.getParameter("firstname"));
        customer.setLastName(req.getParameter("lastname"));
        customer.setEmail(req.getParameter("email"));
        customOrder.setCustomer(customer);
        
        customerOrderService.processCustomerOrder(customOrder);
        
        resp.sendRedirect(req.getContextPath() + "/trips");
    }

}
