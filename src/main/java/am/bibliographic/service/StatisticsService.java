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

    private Statistics statistics;

    @Autowired
    private StatisticsService(Statistics statistics){
        this.statistics = statistics;
    }

    public void add(StatisticsEntity entity){
        statistics.create(entity);
    }

    public StatisticsEntity get(int id){
        return statistics.read(id);
    }

    public List<StatisticsEntity> getAll(){
        return statistics.getAll();
    }

    public void update(StatisticsEntity entity){
        statistics.update(entity);
    }

    public void remove(int id){
        statistics.remove(id);
    }
}
