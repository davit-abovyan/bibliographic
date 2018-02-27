package am.bibliographic.service;

import am.bibliographic.dao.BohJournal;
import am.bibliographic.entity.crosstable.BohJournalEntity;
import am.bibliographic.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public void updateByJournal(BohJournalEntity[] bohIds){
        Set<Integer> journalId = new HashSet<>();
        for(BohJournalEntity i : bohIds)
            journalId.add(i.getJournalId());
        if(journalId.size()!=1) throw new ServiceException("Only one journal Id should be included.");
        bohJournal.removeByJournal(journalId.iterator().next());
        for(BohJournalEntity i : bohIds)
            bohJournal.create(i);
    }
}
