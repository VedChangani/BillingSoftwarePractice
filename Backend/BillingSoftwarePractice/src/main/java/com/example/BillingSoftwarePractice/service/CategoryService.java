package com.example.BillingSoftwarePractice.service;

import com.example.BillingSoftwarePractice.dto.CategoryRequest;
import com.example.BillingSoftwarePractice.dto.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    CategoryResponse add(CategoryRequest request);
    List<CategoryResponse> getAllCategories();
    void delete(String categoryId);
}
