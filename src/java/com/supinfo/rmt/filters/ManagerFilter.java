/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.filters;

import com.supinfo.rmt.controller.UserController;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.entity.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nainterceptor
 */
@WebFilter(urlPatterns={"/faces/manager_home.xhtml", "/faces/add_employee.xhtml", "/faces/add_client.xhtml"})
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        UserController userController =
            (UserController) httpRequest.getSession().getAttribute("userController");
        
        if(null != userController) {
            User user = userController.getLoggedUser();
            if(user instanceof Manager) {
                chain.doFilter(request, response);
                return;
            }
        }
        
        httpResponse.sendRedirect("login.xhtml");
    }

    @Override
    public void destroy() {
        
    }
}