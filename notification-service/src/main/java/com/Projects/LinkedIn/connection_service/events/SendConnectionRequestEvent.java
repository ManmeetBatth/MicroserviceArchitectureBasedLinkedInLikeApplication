package com.Projects.LinkedIn.connection_service.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendConnectionRequestEvent {
    
    private Long senderId;
    private Long receiverId;
}
