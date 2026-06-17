package com.blog.mapper;

import com.blog.domain.Dtos.CreatePostRequestDto;
import com.blog.domain.Dtos.PostDto;
import com.blog.domain.Dtos.UpdatePostRequestDto;
import com.blog.domain.entities.Post;
import com.blog.domain.request.CreatePostRequest;
import com.blog.domain.request.UpdatePostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "status", source = "status")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}
