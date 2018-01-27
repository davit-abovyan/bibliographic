package am.bibliographic.dao;

import am.bibliographic.entity.Entity;
import am.bibliographic.entity.StatisticsEntity;

import java.util.List;

public interface Statistics extends BaseDAO {

    /**
     * Adds new record in statistics table
     * @param entity the entity to be added
     */
    public void create(StatisticsEntity entity);

    /**
     * Gets the record from statistics table with provided id
     * @param id the id of record to be selected
     * @return the entity with provided id
     */
    public StatisticsEntity read(int id);

    /**
     * Returns all current records in statistics table
     * @return list of entities
     */
    public List<StatisticsEntity> getAll();

    /**
     * Update the record in statistics table with details of provided entity
     * @param entity the entity with details to be updated
     */
    public void update(StatisticsEntity entity);

    /**
     * Removes the record from statistics table
     * @param entity the entity to be removed
     */
    public void remove(Entity entity);
}
