package am.bibliographic.service;

import am.bibliographic.dao.Statistics;
import am.bibliographic.entity.StatisticsEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService extends BaseService {
    private Logger log = Logger.getLogger(StatisticsService.class);
    private Statistics statistics;

    @Autowired
    private StatisticsService(Statistics statistics){
        this.statistics = statistics;
    }

    public void add(StatisticsEntity entity){
        try{
            statistics.create(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public StatisticsEntity get(int id){
        try{
            return statistics.read(id);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public List<StatisticsEntity> getAll(){
        try{
            return statistics.getAll();
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
    public void update(StatisticsEntity entity){
        try{
            statistics.update(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public void remove(StatisticsEntity entity){
        statistics.remove(entity);
    }
}
