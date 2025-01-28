package com.Projects.LinkedIn.notification_service.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.Projects.LinkedIn.notification_service.dto.PersonDto;

@FeignClient(name="connections-service", path="/connections")
public interface ConnectionClient {

     @GetMapping("/core/first-degree")
     List<PersonDto> getFirstConnections(@RequestHeader("X-User-Id") Long userId);

    
}