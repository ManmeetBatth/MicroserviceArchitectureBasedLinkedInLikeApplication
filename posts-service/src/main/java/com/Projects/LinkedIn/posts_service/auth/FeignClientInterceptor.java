package com.Projects.LinkedIn.posts_service.auth;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;


@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {

        Long userId= UserContextHolder.getCurrentUserId();
        if(userId!=null){
            requestTemplate.header("X-User-Id", userId.toString());
        }
        
    }
    
}
