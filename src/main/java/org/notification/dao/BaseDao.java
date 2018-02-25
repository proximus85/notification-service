package org.notification.dao;

public interface BaseDao<T> {

    void persist(T t);

}
