package org.notification.serviceimpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.notification.dto.MessageType;
import org.notification.service.Command;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class NotificationsCommandsServiceImplTest {

    @Mock
    private Command sendMailCommand;

    @Mock
    private Command sendSmsCommand;

    private NotificationsCommandsServiceImpl notificationsCommandsService;

    @Before
    public void setUp() {
        given(sendMailCommand.getMessageType()).willReturn(MessageType.MAIL);
        given(sendSmsCommand.getMessageType()).willReturn(MessageType.SMS);

        Collection<Command> commands = Arrays.asList(sendMailCommand, sendSmsCommand);
        notificationsCommandsService = new NotificationsCommandsServiceImpl(commands);
        notificationsCommandsService.mapMessageTypesToCommands();
    }

    @Test
    public void shouldSendMail() {
        //given
        MessageType mail = MessageType.MAIL;

        //when
        notificationsCommandsService.triggerCommandOfType(mail);

        //then
        verify(sendMailCommand, times(1)).execute();
        verify(sendSmsCommand, never()).execute();
    }

    @Test
    public void shouldSendSMS() {
        //given
        MessageType sms = MessageType.SMS;

        //when
        notificationsCommandsService.triggerCommandOfType(sms);

        //then
        verify(sendSmsCommand, times(1)).execute();
        verify(sendMailCommand, never()).execute();
    }

}
