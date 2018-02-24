package org.notification.serviceimpl;

import org.notification.dto.MessageType;
import org.notification.service.Invoker;
import org.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private final Invoker invoker;

    public NotificationServiceImpl(Invoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void invokeMessageSenderOfType(MessageType messageType) {
        invoker.triggerCommandOfType(messageType);
    }

}
