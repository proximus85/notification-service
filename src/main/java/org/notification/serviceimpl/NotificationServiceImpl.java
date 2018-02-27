package org.notification.serviceimpl;

import org.notification.dto.MessageType;
import org.notification.service.NotificationsCommandsService;
import org.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private final NotificationsCommandsService notificationsCommandsService;

    public NotificationServiceImpl(NotificationsCommandsService notificationsCommandsService) {
        this.notificationsCommandsService = notificationsCommandsService;
    }

    @Override
    public void invokeMessageSenderOfType(MessageType messageType) {
        notificationsCommandsService.triggerCommandOfType(messageType);
    }

}
