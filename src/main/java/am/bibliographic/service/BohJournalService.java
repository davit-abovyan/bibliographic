package am.bibliographic.service;

import am.bibliographic.dao.BohJournal;
import am.bibliographic.entity.BohJournalEntity;
import am.bibliographic.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BohJournalService extends BaseService {
    private Logger log = Logger.getLogger(BohJournalService.class);
    private BohJournal bohJournal;

    @Autowired
    private BohJournalService(BohJournal bohJournal){
        this.bohJournal = bohJournal;
    }

    public List<BohJournalEntity> getAllByJournal(int journalId){
        try{
            return bohJournal.getByJournal(journalId);
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }

    public void updateByJournal(int journalId, int[] bohIds){
        try{
            bohJournal.removeByJournal(journalId);
            for(int i : bohIds)
                bohJournal.create(new BohJournalEntity(i, journalId));
        } catch (RuntimeException e){
            log.warn(e.getMessage());
            throw new ServiceException("Error:");
        }
    }
}
