/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.controller;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.services.ClientService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author nainterceptor
 */
@ManagedBean
public class ClientController {
    
    @EJB
    private ClientService clientService;
    
    private Client client;
    
    private List<SelectItem> selectItems;
    
    
    
    public String create() {
        clientService.save(client);
        return "manager_home?faces-redirect=true";
    }

    public Client getClient() {
        if(null == client) {
            client = new Client();
        }
        
        return client;
    }

    public List<SelectItem> getSelectItems() {
        if(null == selectItems) {
            selectItems = new ArrayList<SelectItem>();
            for(Client client : clientService.getAll()) {
                selectItems.add(new SelectItem(client, client.getName()));
            }
        }
        
        return selectItems;
    }
}