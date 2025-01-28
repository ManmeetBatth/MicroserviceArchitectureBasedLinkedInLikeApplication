package com.Projects.LinkedIn.notification_service.consumer;

import java.util.List;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.Projects.LinkedIn.notification_service.clients.ConnectionClient;
import com.Projects.LinkedIn.notification_service.dto.PersonDto;
import com.Projects.LinkedIn.notification_service.entity.Notification;
import com.Projects.LinkedIn.notification_service.repository.NotificationRepository;
import com.Projects.LinkedIn.posts_service.event.PostCreatedEvent;
import com.Projects.LinkedIn.posts_service.event.PostLikedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostsServiceConsumer {

    private final ConnectionClient connectionsClient;
    private final NotificationRepository notificationRepository;

    @KafkaListener(topics = "post-created-topic" , groupId = "notification-service-group")
    public void handlePostCreated(PostCreatedEvent postCreatedEvent){

        List<PersonDto> connections=connectionsClient.getFirstConnections(postCreatedEvent.getCreaterId());

        for(PersonDto connction: connections){
   
      sendNotifications
      (connction.getUserId(), "Your Connection "+ postCreatedEvent.getCreaterId() +" Just Posted! ");

        }
    }

    @KafkaListener(topics="post-liked-topic" , groupId = "notification-service-group")
    public void handlePostLiked(PostLikedEvent postLikedEvent){
        String message = String.format("Your psost, %d was like by %d", postLikedEvent.getPostId(),
        postLikedEvent.getLikedByUserId());

        sendNotifications(postLikedEvent.getCreatorId(), message);
    }

    public void sendNotifications(Long userId, String message){

        Notification notification= new Notification();
        notification.setMessage(message);
        notification.setUserId(userId);

        notificationRepository.save(notification);
        

    }

    
} 