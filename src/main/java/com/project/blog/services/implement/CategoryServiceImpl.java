package com.project.blog.services.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.blog.entities.Category;
import com.project.blog.exceptions.ResourceNotFoundException;
import com.project.blog.payloads.CategoryDto;
import com.project.blog.repo.CategoryRepo;
import com.project.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cate = this.modelMapper.map(categoryDto, Category.class);
		Category addedCate = this.categoryRepo.save(cate);		
		return this.modelMapper.map(addedCate, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cate = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id",categoryId));
		cate.setCategoryTitle(categoryDto.getCategoryTitle());
		cate.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCate = this.categoryRepo.save(cate);
		return this.modelMapper.map(updatedCate, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cate = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id",categoryId));
        this.categoryRepo.delete(cate);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cate = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id",categoryId));      
		return this.modelMapper.map(cate, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> cateDtos =categories.stream().map(cate ->this.modelMapper.map(cate,CategoryDto.class)).collect(Collectors.toList());   
		return cateDtos;
	}

}
