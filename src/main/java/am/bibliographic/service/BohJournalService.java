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

    private BohJournal bohJournal;

    @Autowired
    private BohJournalService(BohJournal bohJournal){
        this.bohJournal = bohJournal;
    }

    public List<BohJournalEntity> getAllByJournal(int journalId){
        return bohJournal.getByJournal(journalId);
    }

    public void updateByJournal(int journalId, int[] bohIds){
        bohJournal.removeByJournal(journalId);
        for(int i : bohIds)
            bohJournal.create(new BohJournalEntity(i, journalId));
    }
}
