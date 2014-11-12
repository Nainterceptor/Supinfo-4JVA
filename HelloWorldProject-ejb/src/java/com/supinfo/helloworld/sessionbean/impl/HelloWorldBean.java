/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.helloworld.sessionbean.impl;

import com.supinfo.helloworld.sessionbean.interfaces.HelloWorldBeanRemote;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author nainterceptor
 */
@Stateless
@EJB(name="java:global/HelloWorldBean", beanInterface=HelloWorldBeanRemote.class)
public class HelloWorldBean implements HelloWorldBeanRemote {
    @Override
    public String getHelloMessage() {
        return "Hello world";
    }
}
