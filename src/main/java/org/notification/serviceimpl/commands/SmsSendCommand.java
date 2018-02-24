package org.notification.serviceimpl.commands;

import org.notification.service.Command;
import org.notification.service.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("SmsSendCommand")
public class SmsSendCommand implements Command {

    @Autowired
    @Qualifier("SmsSenderServiceImpl")
    private Receiver receiver;

    @Override
    public void execute() {
        receiver.performAction();
    }
}
