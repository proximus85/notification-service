package org.notification.serviceimpl;

import org.notification.dao.AuditLogDao;
import org.notification.domain.auditlog.Event;
import org.notification.dto.EventDto;
import org.notification.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogDao auditLogDao;
    private final EventMapperServiceImpl eventMapperService;

    @Autowired
    public AuditLogServiceImpl(AuditLogDao auditLogDao, EventMapperServiceImpl eventMapperService) {
        this.auditLogDao = auditLogDao;
        this.eventMapperService = eventMapperService;
    }

    @Transactional
    @Override
    public List<EventDto> getEvents() {
        Collection<Event> events = Optional.ofNullable(auditLogDao.findAll()).orElse(Collections.emptyList());
        return eventMapperService.mapToDto(events).stream()
                .sorted(comparing(EventDto::getDate))
                .collect(Collectors.toList());
    }
}
