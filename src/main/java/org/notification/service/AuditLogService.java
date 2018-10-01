package org.notification.service;

import org.notification.dto.EventDto;

import java.util.List;

public interface AuditLogService {
    List<EventDto> getEvents();
}
