/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.suprails.entity;

import java.math.BigDecimal;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
/**
 *
 * @author nainterceptor
 */
@StaticMetamodel(Trip.class)
public class Trip_ {
    public static volatile SingularAttribute<Trip, Long> id;
    public static volatile SingularAttribute<Trip, BigDecimal> price;
    public static volatile SingularAttribute<Trip, TrainStation> departureStation;
    public static volatile SingularAttribute<Trip, TrainStation> arrivalStation;
}
