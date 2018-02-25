package org.notification.serviceimpl;

import org.notification.dto.MessageType;
import org.notification.service.Command;
import org.notification.service.Invoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommandInvoker implements Invoker {

    @Autowired
    private List<Command> sendCommands;

    private Map<MessageType, Command> messageTypeCommandMap = null;

    @PostConstruct
    private void initializeCommands() {
        messageTypeCommandMap = sendCommands.stream()
                .collect(Collectors.toMap(s -> s.getMessageType(), s -> s));
    }

    @Override
    public void triggerCommandOfType(MessageType messageType) {
        messageTypeCommandMap.get(messageType).execute();
    }

}
