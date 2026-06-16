package com.blog.controller;

import com.blog.domain.Dtos.CategoryDto;
import com.blog.domain.entities.Category;
import com.blog.domain.request.CreateCategoryRequest;
import com.blog.mapper.CategoryMapper;
import com.blog.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        // TODO
        List<CategoryDto> categories = categoryService.listCategories()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(categories);

    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Valid CreateCategoryRequest request){

        Category categoryToCreate = categoryMapper.toEntity(request);
        Category saveCategory = categoryService.createCategory(categoryToCreate);
        return new ResponseEntity<>(
                categoryMapper.toDto(saveCategory),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
