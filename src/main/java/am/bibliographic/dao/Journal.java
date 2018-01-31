package am.bibliographic.dao;

import am.bibliographic.entity.Entity;
import am.bibliographic.entity.JournalEntity;

import java.util.List;

public interface Journal extends BaseDAO{
    /**
     * Adds new record in journal table
     * @param entity the entity to be added
     * @return id of the new added entity
     */
    public int create(JournalEntity entity);

    /**
     * Gets the record from journal table with provided id
     * @param id the id of record to be selected
     * @return the entity with provided id
     */
    public JournalEntity read(int id);

    /**
     * Returns all current records in journal table
     * @return list of entities
     */
    public List<JournalEntity> getAll();

    /**
     * Update the record in journal table with details of provided entity
     * @param entity the entity with details to be updated
     */
    public void update(JournalEntity entity);

    /**
     * Removes the record from journal table
     * @param id the id of the entity to be removed
     */
    public void remove(int id);
}
