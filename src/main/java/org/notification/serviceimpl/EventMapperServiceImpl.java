package org.notification.serviceimpl;

import org.notification.domain.auditlog.Event;
import org.notification.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class EventMapperServiceImpl {

    public EventDto mapToDto(Event event) {
        return new EventDto(event.getEventType(), event.getCreationTime());
    }

    public Collection<EventDto> mapToDto(Collection<Event> events) {
        return events.stream().map(this::mapToDto).collect(Collectors.toList());
    }

}
