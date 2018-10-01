package org.notification.controller;


import org.notification.dto.EventDto;
import org.notification.dto.MessageType;
import org.notification.service.AuditLogService;
import org.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification-service/")
public class NotificationController {

    private final NotificationService notificationService;
    private final AuditLogService auditLogService;

    @Autowired
    public NotificationController(NotificationService notificationService, AuditLogService auditLogService) {
        this.notificationService = notificationService;
        this.auditLogService = auditLogService;
    }

    @RequestMapping(path = "{messageType}", method = RequestMethod.POST)
    public void sendNotification(@PathVariable("messageType") MessageType messageType) {
        notificationService.invokeMessageSenderOfType(messageType);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<EventDto> getSentCommands() {
        return auditLogService.getEvents();
    }

}
