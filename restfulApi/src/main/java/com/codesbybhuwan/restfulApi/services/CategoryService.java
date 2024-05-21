package com.codesbybhuwan.restfulApi.services;

import com.codesbybhuwan.restfulApi.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

//    CREATE
    public CategoryDto createCategory(CategoryDto categoryDto);

//    UPDATE
public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

//    DELETE
public void deleteCategory(Integer categoryId);

//    GET
public CategoryDto getCategory(Integer categoryId);

//    GETALL
    List<CategoryDto> getCategories();
}
