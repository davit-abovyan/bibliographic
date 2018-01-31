package am.bibliographic.dao;

import am.bibliographic.entity.BOHEntity;
import am.bibliographic.entity.Entity;

import java.util.List;

public interface BOH extends BaseDAO{
    /**
     * Adds new record in boh table
     * @param entity the entity to be added
     * @return id of the new added entity
     */
    public int create(BOHEntity entity);

    /**
     * Gets the record from boh table with provided id
     * @param id the id of record to be selected
     * @return the entity with provided id
     */
    public BOHEntity read(int id);

    /**
     * Returns all current records in boh table
     * @return list of entities
     */
    public List<BOHEntity> getAll();

    /**
     * Update the record in boh table with details of provided entity
     * @param entity the entity with details to be updated
     */
    public void update(BOHEntity entity);

    /**
     * Removes the record from boh table
     * @param id the id of entity to be removed
     */
    public void remove(int id);
}
