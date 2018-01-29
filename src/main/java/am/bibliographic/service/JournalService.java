package am.bibliographic.service;

import am.bibliographic.dao.Journal;
import am.bibliographic.dao.Statistics;
import am.bibliographic.entity.JournalEntity;
import am.bibliographic.entity.StatisticsEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JournalService extends BaseService {
    private Logger log = Logger.getLogger(JournalService.class);
    private Journal journal;

    private Statistics statistics;

    @Autowired
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Autowired
    private JournalService(Journal journal){
        this.journal = journal;
    }

    public int add(JournalEntity entity){
        try{
            int id = journal.create(entity);
            statistics.create(new StatisticsEntity(id));
            return id;
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public JournalEntity get(int id){
        try{
            return journal.read(id);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public List<JournalEntity> getAll(){
        try{
            return journal.getAll();
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
    public void update(JournalEntity entity){
        try{
            journal.update(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public void remove(JournalEntity entity){
        try{
            statistics.remove(entity.getId());
            journal.remove(entity);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
}
