package org.notification.service;

import org.notification.dto.MessageType;

public interface NotificationService {

    void sendNotification(MessageType messageType);

}
