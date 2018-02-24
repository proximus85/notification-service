package org.notification.serviceimpl;

import org.notification.dto.MessageType;
import org.notification.service.Command;
import org.notification.service.Invoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommandInvoker implements Invoker {

    private Map<MessageType, Command> messageTypeCommandMap = null;

    @Autowired
    @Qualifier("SmsSendCommand")
    private Command smsSendCommand;

    @Autowired
    @Qualifier("MailSendCommand")
    private Command mailSendCommand;

    @PostConstruct
    private void initializeCommands() {
        messageTypeCommandMap = new HashMap<>();
        messageTypeCommandMap.put(MessageType.SMS, smsSendCommand);
        messageTypeCommandMap.put(MessageType.MAIL, mailSendCommand);
    }

    @Override
    public void triggerCommandOfType(MessageType messageType) {
        messageTypeCommandMap.get(messageType).execute();
    }

}
