package com.Projects.LinkedIn.posts_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PostCreateRequestDto {

    private String content;
    
}
