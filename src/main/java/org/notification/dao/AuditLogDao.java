package org.notification.dao;

import org.notification.domain.auditlog.Event;

import java.util.Collection;

public interface AuditLogDao<T> extends BaseDao<T> {

    /**
     * Finds all events. Returns null when no event is found.
     *
     * @return Collection<Event>
     */
    Collection<Event> findAll();
}
