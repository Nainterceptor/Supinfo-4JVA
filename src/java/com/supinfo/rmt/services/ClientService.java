/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.services;

import com.supinfo.rmt.entity.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nainterceptor
 */
@Stateless
public class ClientService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Client save(Client client) {
        em.persist(client);
        return client;
    }
    
    public List<Client> getAll() {
        return em.createQuery("SELECT c FROM Client c").getResultList();
    }

    public Object findById(long id) {
        return em.find(Client.class, id);
    }
}