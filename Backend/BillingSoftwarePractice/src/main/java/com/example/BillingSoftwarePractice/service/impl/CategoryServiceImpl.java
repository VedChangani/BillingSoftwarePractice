package com.example.BillingSoftwarePractice.service.impl;

import com.example.BillingSoftwarePractice.dto.CategoryRequest;
import com.example.BillingSoftwarePractice.dto.CategoryResponse;
import com.example.BillingSoftwarePractice.entity.Category;
import com.example.BillingSoftwarePractice.repository.CategoryRepository;
import com.example.BillingSoftwarePractice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse add(CategoryRequest request) {
        Category newCategory = convertToEntity(request);
        categoryRepository.save(newCategory);

        return convertToResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> convertToResponse(category))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
        Category exsitingCategory = categoryRepository.findByCategoryId(categoryId).orElseThrow(
                ()  -> new RuntimeException("Category not found" + categoryId)
        );
        categoryRepository.delete(exsitingCategory);
    }

    private Category convertToEntity(CategoryRequest request){
        return Category.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }

    public CategoryResponse convertToResponse(Category newCategory){
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .build();
    }
}
