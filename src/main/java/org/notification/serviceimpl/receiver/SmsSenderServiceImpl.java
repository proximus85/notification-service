package org.notification.serviceimpl.receiver;

import lombok.extern.slf4j.Slf4j;
import org.notification.dao.AuditLogDao;
import org.notification.domain.auditlog.Event;
import org.notification.dto.EventType;
import org.notification.service.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Qualifier("SmsSenderServiceImpl")
public class SmsSenderServiceImpl implements Receiver {

    @Autowired
    private final AuditLogDao auditLogDao;

    public SmsSenderServiceImpl(AuditLogDao auditLogDao) {
        this.auditLogDao = auditLogDao;
    }

    @Override
    @Transactional
    public void performAction() {
        log.info("Sms sent.");
        auditLogDao.persist(new Event(EventType.SMS_SENT));
    }

}
