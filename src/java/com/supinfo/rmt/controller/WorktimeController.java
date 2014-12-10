/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Worktime;
import com.supinfo.rmt.services.WorktimeService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author nainterceptor
 */
@ManagedBean
public class WorktimeController {
    
    @EJB
    private WorktimeService worktimeService;
    
    @ManagedProperty("#{userController}")
    private UserController userController;
    
    private Worktime worktime;
    
    private DataModel<Worktime> dataModel;
    
    public String create() {
        worktime.setEmployee((Employee) userController.getLoggedUser());
        worktimeService.save(worktime);
        
        return "employee_home?faces-redirect=true";
    }
    
    public String remove() {
        worktimeService.remove(dataModel.getRowData());
        return "employee_home?faces-redirect=true";
    }

    public Worktime getWorktime() {
        if(null == worktime) {
            worktime = new Worktime();
        }
        
        return worktime;
    }

    public DataModel<Worktime> getDataModel() {
        if(null == dataModel) {
            dataModel = new ListDataModel<Worktime>(worktimeService.getWorktimesByEmployee((Employee) userController.getLoggedUser()));
        }
        return dataModel;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
    
    
    
}