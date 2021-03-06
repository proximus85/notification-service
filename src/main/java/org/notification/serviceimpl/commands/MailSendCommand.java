package org.notification.serviceimpl.commands;

import org.notification.dto.MessageType;
import org.notification.service.Command;
import org.notification.service.Receiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MailSendCommand")
public class MailSendCommand implements Command {

    @Autowired
    @Qualifier("MailSenderServiceImpl")
    private Receiver receiver;

    @Override
    public void execute() {
        receiver.performAction();
    }

    @Override
    public MessageType getMessageType() {
        return MessageType.MAIL;
    }

}
