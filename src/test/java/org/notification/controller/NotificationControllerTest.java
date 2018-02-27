package org.notification.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.notification.dto.MessageType;
import org.notification.service.NotificationService;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    @Test
    public void shouldSendSomeNotification() {
        //when
        notificationController.sendNotification(MessageType.MAIL);

        //then
        verify(notificationService).invokeMessageSenderOfType(MessageType.MAIL);
    }

}
