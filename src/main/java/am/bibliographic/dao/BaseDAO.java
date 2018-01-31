package am.bibliographic.dao;

import am.bibliographic.entity.Entity;

public interface BaseDAO {
    default void remove(int id){}
    default void remove(Entity entity){}
}
