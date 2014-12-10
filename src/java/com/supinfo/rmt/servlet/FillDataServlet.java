/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.servlet;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.services.UserService;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "FillDataServlet", urlPatterns = {"/FillDataServlet"})
public class FillDataServlet extends HttpServlet {

    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Manager manager = new Manager();
        manager.setUsername("foo");
        manager.setPassword("foo");
        manager.setFirstname("Foo");
        manager.setLastname("Foo");
        manager.setEmail("foo@bar.com");
        manager.setBirthDate(new Date(19, 10, 01));
        userService.save(manager);
        
        Employee employee = new Employee();
        employee.setUsername("bar");
        employee.setPassword("bar");
        employee.setFirstname("Bar");
        employee.setLastname("Bar");
        employee.setEmail("bar@foo.com");
        employee.setBirthDate(new Date(20, 9, 18));
        employee.setManager(manager);
        userService.save(employee);
        
    }

}
