/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.services;

import com.supinfo.rmt.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nainterceptor
 */
@Stateless
public class UserService {
    
    @PersistenceContext
    private EntityManager em;
    
    public User save(User user) {
        
        try {
            User existingUser = (User) em.createQuery("SELECT u from User u WHERE u.username=:username")
                .setParameter("username", user.getUsername())
                .getSingleResult();
            
            return null; // Username already exists
            
        } catch(NoResultException e) {
            // OK
        }
        
        em.persist(user);
        return user;
    }
    
    public User login(String username, String password){
        
        try {
            return (User) em.createQuery("SELECT u FROM User u "
                    + "WHERE u.username=:username AND u.password=:password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null; // user not exist
        }
    }
}