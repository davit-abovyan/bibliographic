package am.bibliographic.dao;

import am.bibliographic.entity.Entity;
import am.bibliographic.entity.PersonEntity;

import java.util.List;

public interface Person extends BaseDAO{

    /**
     * Adds new record in person table
     * @param entity the entity to be added
     * @return id of the new added entity
     */
    public int create(PersonEntity entity);

    /**
     * Gets the record from person table with provided id
     * @param id the id of record to be selected
     * @return the entity with provided id
     */
    public PersonEntity read(int id);

    /**
     * Returns all current records in person table
     * @return list of entities
     */
    public List<PersonEntity> getAll();

    /**
     * Update the record in person table with details of provided entity
     * @param entity the entity with details to be updated
     */
    public void update(PersonEntity entity);

    /**
     * Removes the record from person table
     * @param id the id of the entity to be removed
     */
    public void remove(int id);
}
