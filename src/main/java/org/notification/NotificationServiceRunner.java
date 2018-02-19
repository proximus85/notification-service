package org.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NotificationServiceRunner {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceRunner.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
