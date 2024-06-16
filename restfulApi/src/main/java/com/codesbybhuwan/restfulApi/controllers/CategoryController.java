package com.codesbybhuwan.restfulApi.controllers;

import com.codesbybhuwan.restfulApi.payloads.ApiResponse;
import com.codesbybhuwan.restfulApi.payloads.CategoryDto;
import com.codesbybhuwan.restfulApi.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    1. Create
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoyDto){

        CategoryDto createCategory = this.categoryService.createCategory(categoyDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

//    2. Update
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer catId){

        CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
    }

//    3. Delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){

    this.categoryService.deleteCategory(catId);
    return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
    }

    //    4. Get
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){

        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    //    5. GetAll
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){

    //    List<CategoryDto> categories = this.categoryService.getAllCategories();
        return ResponseEntity.ok(this.categoryService.getCategories());
        }
}
