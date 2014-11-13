package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.TripDao;
import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;
import com.supinfo.suprails.entity.Trip_;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author bargenson
 */
@Stateless
public class JpaTripDao implements TripDao {

    @PersistenceContext
    private EntityManager em;

    
    @Override
    public Trip addTrip(Trip trip) {
        em.persist(trip);
        return trip;
    }

    @Override
    public List<Trip> getAllTrips() {
        return em.createQuery("SELECT t FROM Trip t").getResultList();
    }

    @Override
    public Trip findTripById(Long tripId) {
        return em.find(Trip.class, tripId);
    }

    @Override
    public void removeTrip(Trip trip) {
        em.remove(trip);
    }

    @Override
    public List<Trip> getTripsByFilter(TrainStation departure, TrainStation arrival, BigDecimal price) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trip> query = cb.createQuery(Trip.class);
        Root<Trip> trip = query.from(Trip.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        if(departure != null) {
            predicates.add(
                cb.equal(trip.get(Trip_.departureStation), departure)
            );
        }
        
        if(arrival != null) {
            predicates.add(
                cb.equal(trip.get(Trip_.arrivalStation), arrival)
            );
        }
        
        if(price != null) {
            predicates.add(
                cb.lessThanOrEqualTo(trip.get(Trip_.price), price)
            );
        }
        
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return em.createQuery(query).getResultList();
    }
    
}
