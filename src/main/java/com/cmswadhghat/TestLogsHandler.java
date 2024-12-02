package com.cmswadhghat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestLogsHandler {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public TestLogsHandler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendTestLog(String message) {
        // Send logs to the frontend in real-time
        messagingTemplate.convertAndSend("/topic/logs", message);
    }
}
