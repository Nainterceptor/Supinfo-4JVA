/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.helloworld.sessionbean.interfaces;

import javax.ejb.Remote;

/**
 *
 * @author nainterceptor
 */
@Remote
public interface HelloWorldBeanRemote {
    public String getHelloMessage();
}
