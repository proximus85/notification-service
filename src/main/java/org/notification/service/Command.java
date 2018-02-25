package org.notification.service;

import org.notification.dto.MessageType;

public interface Command {
    /**
     * Performs command execution.
     */
    void execute();

    /**
     * Gets type for which this command was set up.
     */
    MessageType getMessageType();
}
