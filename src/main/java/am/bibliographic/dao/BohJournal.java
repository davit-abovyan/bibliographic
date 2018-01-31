package am.bibliographic.dao;

import am.bibliographic.entity.BohJournalEntity;
import am.bibliographic.entity.Entity;
import jdk.nashorn.internal.runtime.regexp.joni.constants.EncloseType;

import java.util.List;

public interface BohJournal extends BaseDAO {
    /**
     * Adds new record in boh_journal table
     * @param entity the entity to be added
     * @return true if new added entity, otherwise false
     */
    public boolean create(BohJournalEntity entity);


    /**
     * Returns all records with provided boh id in boh_journal table
     * @return list of entities
     */
    public List<BohJournalEntity> getByJournal(int bohId);

    /**
     * Returns all records with provided journal id in boh_journal table
     * @return list of entities
     */
    public List<BohJournalEntity> getByBoh(int journalId);


    /**
     * Return whether the BOH is related to journal with provided ids
     * @param bohId the BOH id
     * @param journalId the journal id
     * @return true if they are related, otherwise false
     */
    public boolean getByBOHAndJournal(int bohId, int journalId);

    /**
     * Removes the record from boh_journal table
     * @param entity the entity that should be removed
     */
    public void remove(Entity entity);

    /**
     * Removes the record from boh_journal table
     * @param journalId the id of journal all BOHs related to which should be removed
     */
    public void removeByJournal(int journalId);
}
