/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.entity.User;
import com.supinfo.rmt.services.UserService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author nainterceptor
 */
@ManagedBean
@SessionScoped
public class UserController {
    
    @EJB
    private UserService userService;
    
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    
    private User loggedUser;
    
    public String login() {
        loggedUser = userService.login(username, password);
        
        if(null == loggedUser) {
            return null;
        }
        
        username = null;
        password = null;
        
        if(loggedUser instanceof Manager) {
            return "manager_home?faces-redirect=true";
        } else {
            return "employee_home?faces-redirect=true";
        }
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
    
    
}