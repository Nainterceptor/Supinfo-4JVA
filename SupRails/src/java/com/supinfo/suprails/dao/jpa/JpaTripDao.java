package com.supinfo.suprails.dao.jpa;

import com.supinfo.suprails.dao.TripDao;
import com.supinfo.suprails.entity.Trip;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

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
    
}
