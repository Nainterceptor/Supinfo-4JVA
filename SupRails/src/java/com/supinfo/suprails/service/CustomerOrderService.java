package com.supinfo.suprails.service;

import com.supinfo.suprails.dao.CustomerOrderDao;
import com.supinfo.suprails.entity.Customer;
import com.supinfo.suprails.entity.CustomerOrder;

import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CustomerOrderService {
    @EJB
    private PrinterMessageService printerMessageService;

    @EJB
    private CustomerOrderDao customerOrderDao;

    public void processCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
        sendEmail(customerOrder.getCustomer());
        printerMessageService.printCustomerOrder(customerOrder);
    }

    @Asynchronous
    public void sendEmail(Customer customer) {
        System.out.println("Send mail to " + customer.getFirstName()
                + " " + customer.getLastName() + " at " + customer.getEmail());
    }
}
