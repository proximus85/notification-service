package org.notification.serviceimpl;

import org.notification.dto.MessageType;
import org.notification.service.Command;
import org.notification.service.NotificationsCommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NotificationsCommandsServiceImpl implements NotificationsCommandsService {

    private static Map<MessageType, Command> messageTypeToCommandMap = null;
    private final Collection<Command> commands;

    @Autowired
    public NotificationsCommandsServiceImpl(Collection<Command> commands) {
        this.commands = commands;
    }

    @PostConstruct
    void mapMessageTypesToCommands() {
        messageTypeToCommandMap = commands.stream().collect(
                Collectors.collectingAndThen(Collectors.toMap(s -> s.getMessageType(), s -> s),
                        Collections::<MessageType, Command>unmodifiableMap));
    }

    @Override
    public void triggerCommandOfType(MessageType messageType) {
        messageTypeToCommandMap.get(messageType).execute();
    }

}
