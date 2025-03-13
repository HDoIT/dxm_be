package com.dxm.dxmbe.service;

import com.dxm.dxmbe.model.Category;
import com.dxm.dxmbe.request.CategoryRequest;

public interface CategoryService {

    int addCategory(CategoryRequest.createCategory createCategory);

    Category getCategory(int id);
}
