package org.notification.service;

import org.notification.dto.MessageType;

public interface NotificationsCommandsService {

    /**
     * Triggers message type specific command.
     *
     * @param messageType message type.
     */
    void triggerCommandOfType(MessageType messageType);
}
