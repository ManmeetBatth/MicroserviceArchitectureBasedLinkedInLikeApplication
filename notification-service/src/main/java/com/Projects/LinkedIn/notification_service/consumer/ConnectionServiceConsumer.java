package com.Projects.LinkedIn.notification_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Projects.LinkedIn.connection_service.events.AcceptConnectionRequestEvent;
import com.Projects.LinkedIn.connection_service.events.SendConnectionRequestEvent;
import com.Projects.LinkedIn.notification_service.service.SendNotification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
public class ConnectionServiceConsumer {

    private final SendNotification sendNotification;
    
 @KafkaListener(topics = "send-connection-request-topic")
    public void handleSendConnectionRequest(SendConnectionRequestEvent sendConnectionRequestEvent) {
        log.info("handle connections: handleSendConnectionRequest: {}", sendConnectionRequestEvent);
        String message =
                "You have receiver a connection request from user with id: %d"+sendConnectionRequestEvent.getSenderId();
        sendNotification.send(sendConnectionRequestEvent.getReceiverId(), message);
    }

    @KafkaListener(topics = "accept-connection-request-topic")
    public void handleAcceptConnectionRequest(AcceptConnectionRequestEvent acceptConnectionRequestEvent) {
        log.info("handle connections: handleAcceptConnectionRequest: {}", acceptConnectionRequestEvent);
        String message =
                "Your connection request has been accepted by the user with id: %d"+acceptConnectionRequestEvent.getReceiverId();
        sendNotification.send(acceptConnectionRequestEvent.getSenderId(), message);
    }

}
