package am.bibliographic.dao;

import am.bibliographic.entity.Entity;
import am.bibliographic.entity.UserEntity;

import java.util.List;

public interface UserInfo extends BaseDAO{
    /**
     * Adds new record in user table
     * @param entity the entity to be added
     * @return id of the new added entity
     */
    boolean create(UserEntity entity);

    /**
     * Gets the record from user table with provided id
     * @param userName the id of record to be selected
     * @return the entity with provided id
     */
    UserEntity read(String userName);

    /**
     * Returns all current records in user table
     * @return list of entities
     */
    List<UserEntity> getAll();

    /**
     * Login to system
     * @param name username
     * @param password user password
     * @return true if credentials are true
     */
    boolean login(String name, String password);

    /**
     * Update the record in user table with details of provided entity
     * @param entity the entity with details to be updated
     */
    void update(UserEntity entity);

    /**
     * Removes the record from user table
     * @param entity the entity to be removed
     */
    void remove(Entity entity);
}
