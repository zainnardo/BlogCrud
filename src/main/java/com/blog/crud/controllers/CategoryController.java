package com.blog.crud.controllers;

import com.blog.crud.payloads.CategoryDto;
import com.blog.crud.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> creageCategoryController(@Valid @RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<CategoryDto>(categoryService.creageCategory(categoryDto),HttpStatus.CREATED);
	}
	@PutMapping("/upadate/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategoryController(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId) {
		return new ResponseEntity<CategoryDto>(categoryService.updateCategory(categoryDto, categoryId),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<CategoryDto> deleteCategoryController(@PathVariable Integer categoryId) {
		return new ResponseEntity<CategoryDto>(categoryService.deleteCategory(categoryId),HttpStatus.OK);
	}
	@GetMapping("/getcategory/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryController(@PathVariable Integer categoryId) {
		return new ResponseEntity<CategoryDto>(categoryService.getCategory(categoryId),HttpStatus.OK);
	}
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDto>> getAllCategoriesController(){
		return new ResponseEntity<List<CategoryDto>>(categoryService.getAllCategories(),HttpStatus.OK);
	}
}
