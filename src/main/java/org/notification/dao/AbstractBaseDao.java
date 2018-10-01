package org.notification.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public abstract class AbstractBaseDao<T> {

    private final Class<T> classType;

    @PersistenceContext
    protected EntityManager entityManager;

    protected AbstractBaseDao(Class<T> classType) {
        super();
        this.classType = classType;
    }

    public void persist(T entity) {
        entityManager.persist(entity);
    }

    public Collection<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery();

        Root<T> root = cq.from(classType);
        cq.select(root);

        return entityManager.createQuery(cq).getResultList();
    }
}
