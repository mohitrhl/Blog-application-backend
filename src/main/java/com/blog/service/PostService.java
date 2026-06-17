package com.blog.service;

import com.blog.domain.entities.Post;
import com.blog.domain.entities.User;

import com.blog.domain.request.CreatePostRequest;
import com.blog.domain.request.UpdatePostRequest;

import java.util.List;
import java.util.UUID;

public interface PostService {

    Post getPost(UUID id);
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
    Post updatePost(UUID id, UpdatePostRequest updatePostRequest);
    void deletePost(UUID id);
}
