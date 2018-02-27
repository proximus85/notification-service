package org.notification.serviceimpl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.notification.dto.MessageType;
import org.notification.service.NotificationsCommandsService;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceImplTest {

    @Mock
    private NotificationsCommandsService notificationsCommandsService;

    @InjectMocks
    private NotificationServiceImpl notificationService;

    @Test
    public void shouldSendMessage() {
        //given
        MessageType messageToSendType = MessageType.MAIL;

        //when
        notificationService.invokeMessageSenderOfType(messageToSendType);

        //then
        verify(notificationsCommandsService).triggerCommandOfType(messageToSendType);
    }

}
