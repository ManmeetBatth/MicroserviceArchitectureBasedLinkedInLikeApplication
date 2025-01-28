package com.Projects.LinkedIn.posts_service.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@SuppressWarnings("unused")
public class PostDto {

    private Long id;

    private String content;

    private Long userId;

    private LocalDateTime createdAt;
    
}
