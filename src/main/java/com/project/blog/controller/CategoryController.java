package com.project.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blog.payloads.ApiResponse;
import com.project.blog.payloads.CategoryDto;
import com.project.blog.services.CategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/categories")
//@Tag(name = "Blog_Category", description = "Blog_Category APIs")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	@PutMapping("/{cateId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto , @PathVariable Integer cateId){
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,cateId);
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/{cateId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer cateId){
	    this.categoryService.deleteCategory(cateId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted",true),HttpStatus.OK);
	}
	
	@GetMapping("/{cateId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer cateId){
		CategoryDto categoryDto = this.categoryService.getCategory(cateId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
	   List<CategoryDto> categories =  this.categoryService.getCategories();
	   return ResponseEntity.ok(categories);
	}

}
