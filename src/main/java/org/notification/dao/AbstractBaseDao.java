package org.notification.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractBaseDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    public void persist(T entity) {
        entityManager.persist(entity);
    }
}
