package org.notification.serviceimpl.receiver;

import lombok.extern.slf4j.Slf4j;
import org.notification.service.Receiver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("MailSenderServiceImpl")
public class MailSenderServiceImpl implements Receiver {

    @Override
    public void performAction() {
        log.info("Mail sent.");
    }
}
