package org.notification.domain.auditlog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.notification.domain.BaseEntity;
import org.notification.dto.EventType;

import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "EVENT")
@AllArgsConstructor
public class Event extends BaseEntity {

    private EventType eventType;

}
