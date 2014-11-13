package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.TrainStation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bargenson
 */
@Local
public interface TrainStationDao {
    
    TrainStation addTrainStation(TrainStation station);

    List<TrainStation> getAllTrainStations();

    TrainStation findTrainStationById(Long departureId);
    
}
