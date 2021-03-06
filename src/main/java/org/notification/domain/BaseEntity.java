package org.notification.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    protected long id;

    protected Date creationTime;

    protected Date updateTime;

    @PrePersist
    private void setCreationTime() {
        this.creationTime = new Date();
    }

    @PreUpdate
    private void setUpdateTime() {
        this.updateTime = new Date();
    }
}
