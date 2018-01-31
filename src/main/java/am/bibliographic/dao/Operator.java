package am.bibliographic.dao;

import am.bibliographic.entity.Entity;
import am.bibliographic.entity.OperatorEntity;

import java.util.List;

public interface Operator extends BaseDAO {
    /**
     * Adds new record in operator table
     * @param entity the entity to be added
     * @return id of the new added entity
     */
    public int create(OperatorEntity entity);

    /**
     * Gets the record from operator table with provided id
     * @param id the id of record to be selected
     * @return the entity with provided id
     */
    public OperatorEntity read(int  id);

    /**
     * Returns all current records in operator table
     * @return list of entities
     */
    public List<OperatorEntity> getAll();

    /**
     * Update the record in operator table with details of provided entity
     * @param entity the entity with details to be updated
     */
    public void update(OperatorEntity entity);

    /**
     * Removes the record from operator table
     * @param id the id of the entity to be removed
     */
    public void remove(int id);
}
