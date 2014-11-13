/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.web.servlet;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.service.TrainStationService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ListTrainStationsServlet", urlPatterns = {"/train-stations"})
public class ListTrainStationsServlet extends HttpServlet {

    @EJB
    private TrainStationService trainStationService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TrainStation> trainStations = trainStationService.getAllTrainStations();
        
        req.setAttribute("trainStations", trainStations);
        req.getRequestDispatcher("/jsp/listTrainStations.jsp").forward(req, resp);
    }
    
}
