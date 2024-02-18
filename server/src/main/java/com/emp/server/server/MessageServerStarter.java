package com.emp.server.server;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageServerStarter implements ApplicationListener<ApplicationReadyEvent> {


    private MessageServer server;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        server.startServer();
    }
}