package org.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class EventDto {
    private EventType eventType;
    private Date date;
}
