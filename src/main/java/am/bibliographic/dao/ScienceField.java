package am.bibliographic.dao;

import am.bibliographic.entity.Entity;
import am.bibliographic.entity.ScienceFieldEntity;

import java.util.List;

public interface ScienceField extends BaseDAO {
    /**
     * Adds new record in science_field table
     * @param entity the entity to be added
     * @return id of the new added entity
     */
    public int create(ScienceFieldEntity entity);

    /**
     * Gets the record from science_field table with provided id
     * @param id the id of record to be selected
     * @return the entity with provided id
     */
    public ScienceFieldEntity read(int id);

    /**
     * Returns all current records in science_field table
     * @return list of entities
     */
    public List<ScienceFieldEntity> getAll();

    /**
     * Update the record in science_field table with details of provided entity
     * @param entity the entity with details to be updated
     */
    public void update(ScienceFieldEntity entity);

    /**
     * Removes the record from science_field table
     * @param id the id of the entity to be removed
     */
    public void remove(int id);
}
