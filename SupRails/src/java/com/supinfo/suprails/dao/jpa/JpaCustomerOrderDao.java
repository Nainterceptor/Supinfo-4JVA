package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.CustomerOrder;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class JpaCustomerOrderDao implements CustomerOrderDao {

    @PersistenceContext(unitName = "SupRailsPU")
    private EntityManager em;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        em.persist(customerOrder);
    }
}
