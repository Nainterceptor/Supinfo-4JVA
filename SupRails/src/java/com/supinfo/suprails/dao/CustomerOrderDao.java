package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.CustomerOrder;

import javax.ejb.Local;

@Local
public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);
}
