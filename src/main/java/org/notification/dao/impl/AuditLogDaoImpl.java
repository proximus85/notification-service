package org.notification.dao.impl;

import org.notification.dao.AbstractBaseDao;
import org.notification.dao.AuditLogDao;
import org.notification.domain.auditlog.Event;
import org.springframework.stereotype.Repository;

@Repository
public class AuditLogDaoImpl extends AbstractBaseDao<Event> implements AuditLogDao<Event> {

    public void persist(Event event) {
        entityManager.persist(event);
    }

}
