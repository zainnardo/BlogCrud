package com.blog.crud.services;

import com.blog.crud.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
	public CategoryDto creageCategory(CategoryDto categoryDto);
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	public CategoryDto deleteCategory(Integer categoryId);
	public CategoryDto getCategory(Integer categoryId);
	public List<CategoryDto> getAllCategories();
}
