package org.notification.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.notification.dto.MessageType;
import org.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;

import static org.mockito.Mockito.verify;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class NotificationControllerTest {

    public static final Object EMPTY_BODY = null;

    @LocalServerPort
    int port;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    @MockBean
    private NotificationService notificationService;

    @Test
    public void shouldInvokeNotificationServiceWithMailMessageTypeParameter() throws UnknownHostException {
        //given
        MessageType messageType = MessageType.MAIL;
        String url = createURL(String.format("%s%s", "/notification-service/", messageType.name()));

        //when
        restTemplate.postForLocation(url, EMPTY_BODY);

        //then
        verify(notificationService).sendNotification(messageType);
    }

    private String createURL(String url) {
        return String.format("%s%s%s", "http://localhost:", port, url);
    }
}
