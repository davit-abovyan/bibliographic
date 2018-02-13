package am.bibliographic.service;

import am.bibliographic.dao.Journal;
import am.bibliographic.dao.Statistics;
import am.bibliographic.entity.JournalEntity;
import am.bibliographic.entity.StatisticsEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        int id = journal.create(entity);
        statistics.create(new StatisticsEntity(id));
        return id;
    }

    public JournalEntity get(int id){
        return journal.read(id);
    }

    public List<JournalEntity> getAll(){
        return journal.getAll();
    }

    public void update(JournalEntity entity){
        journal.update(entity);
    }

    public void remove(int id){
        statistics.remove(id);
        journal.remove(id);
    }
}
