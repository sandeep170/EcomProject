package com.samplespringbootcode.blog.services.impl;

import com.samplespringbootcode.blog.enitity.Category;
import com.samplespringbootcode.blog.exceptions.ResourceNotFoundException;
import com.samplespringbootcode.blog.payloads.CategoryDto;
import com.samplespringbootcode.blog.repositories.CategoryRepo;
import com.samplespringbootcode.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
       Category category = this.modelMapper.map(categoryDto, Category.class);
       Category addedCategory = this.categoryRepo.save(category);
       return this.modelMapper.map(addedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("categories","categoryId",categoryId));
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        category.setCategoryTitle(categoryDto.getCategoryTitle());

        Category updatedCategory = this.categoryRepo.save(category);

        return this.modelMapper.map(updatedCategory, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category deletedCategory = this.categoryRepo.findById(categoryId).orElseThrow(() ->new ResourceNotFoundException("Categories","CategoryId",categoryId));
        this.categoryRepo.delete(deletedCategory);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category getCategoryDetails = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Categories","categoryId",categoryId));
        return this.modelMapper.map(getCategoryDetails, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> getListOfCategoryDetails = this.categoryRepo.findAll();
        return getListOfCategoryDetails.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }
}
