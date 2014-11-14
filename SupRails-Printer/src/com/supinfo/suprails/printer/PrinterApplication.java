/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.printer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author nainterceptor
 */
public class PrinterApplication {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     * @throws javax.jms.JMSException
     */
    public static void main(String[] args) throws NamingException, JMSException {
        InitialContext context = new InitialContext();
        
        ConnectionFactory connectionFactory =
                (ConnectionFactory) context.lookup("jms/SupRailsFactory");
        
        Destination destination = (Destination) context.lookup("jms/SupRails");
        Connection connection = connectionFactory.createConnection();
        
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        MessageConsumer consumer = session.createConsumer(destination);
        
        System.out.println("En attente de message...");
        
        consumer.setMessageListener((Message message) -> {
            TextMessage textMessage;
            
            try {
                textMessage = (TextMessage) message;
            } catch (ClassCastException e) {
                System.out.println("Invalid message received : " + e.getMessage());
                return;
            }
            
            try {
                System.out.println("Message received : " + textMessage.getText());
            } catch (JMSException ex) {
                Logger.getLogger(PrinterApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
        
        connection.start();
    }
    
}
