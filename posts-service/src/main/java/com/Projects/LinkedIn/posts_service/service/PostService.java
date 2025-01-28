package com.Projects.LinkedIn.posts_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.Projects.LinkedIn.posts_service.auth.UserContextHolder;
import com.Projects.LinkedIn.posts_service.dto.PersonDto;
import com.Projects.LinkedIn.posts_service.dto.PostCreateRequestDto;
import com.Projects.LinkedIn.posts_service.dto.PostDto;
import com.Projects.LinkedIn.posts_service.entity.Post;
import com.Projects.LinkedIn.posts_service.event.PostCreatedEvent;
import com.Projects.LinkedIn.posts_service.exception.ResourceNotFoundException;
import com.Projects.LinkedIn.posts_service.repository.PostsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings("unused")
public class PostService {


    private final PostsRepository postsRepository;
    private final ModelMapper modelMapper;

    private final KafkaTemplate<Long, PostCreatedEvent> kafkaTemplate;

    public PostDto createPost(PostCreateRequestDto postDto) {

        Long userId =UserContextHolder.getCurrentUserId();
        Post post= modelMapper.map(postDto, Post.class);
        post.setUserId(userId);

        Post savedPost = postsRepository.save(post);
         
        PostCreatedEvent postCreatedEvent = PostCreatedEvent.builder()
             .postId(savedPost.getId())
             .createrId(savedPost.getUserId())
             .content(savedPost.getContent())
             .build();

        kafkaTemplate.send("post-created-topic",savedPost.getId(), postCreatedEvent);

        return modelMapper.map(savedPost,PostDto.class);
       
    }
    public PostDto getPostById(Long postId) {
        log.debug("Retrieving post with ID: {}", postId);

      Long userId = UserContextHolder.getCurrentUserId();


        Post post = postsRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Post not found with id: "+postId));
        return modelMapper.map(post, PostDto.class);
    }

    public List<PostDto> getAllPostsOfUser(Long userId) {
        List<Post> posts = postsRepository.findByUserId(userId);

        return posts
            .stream()
            .map((element) -> modelMapper.map(element, PostDto.class))
            .collect(Collectors.toList());
    }
    
}
