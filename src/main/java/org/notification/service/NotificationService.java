package org.notification.service;

import org.notification.dto.MessageType;

public interface NotificationService {
    /**
     * Sends messages of specific type.
     *
     * @param messageType message type.
     */
    void invokeMessageSenderOfType(MessageType messageType);
}
