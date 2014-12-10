/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.rmt.services;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nainterceptor
 */
@Stateless
public class EmployeeService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Employee save(Employee employee) {
        
        try {
            Employee existing = (Employee) em.createQuery("SELECT e from Employee e WHERE e.username=:username")
                .setParameter("username", employee.getUsername())
                .getSingleResult();
            
            return null; // Username already exists
            
        } catch(NoResultException e) {
            // OK
        }
        
        em.persist(employee);
        return employee;
    }
    
    public List<Employee> getEmployeesByManager(Manager manager) {
        return em.createQuery("SELECT e FROM Employee e "
                + "WHERE e.manager=:manager")
                .setParameter("manager", manager)
                .getResultList();
    }
}