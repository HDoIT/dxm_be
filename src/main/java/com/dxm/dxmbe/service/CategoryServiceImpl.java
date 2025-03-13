package com.dxm.dxmbe.service;

import com.dxm.dxmbe.model.Category;
import com.dxm.dxmbe.repository.CategoryRepository;
import com.dxm.dxmbe.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public int addCategory(CategoryRequest.createCategory createCategory) {
        try{
            Category category = Category.builder()
                    .name(createCategory.getName())
                    .description(createCategory.getDescription())
                    .icon(createCategory.getIcon())
                    .build();
            categoryRepository.save(category);
            return 1;
        }catch (Exception e){

        }
        return -1;
    }

    @Override
    public Category getCategory(int id) {
        return null;
    }

}
