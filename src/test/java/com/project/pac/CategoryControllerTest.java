package com.project.pac;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.project.pac.category.CategoryFactory;
import com.project.pac.category.CategoryRepository;
import com.project.pac.category.CategoryService;
import com.project.pac.category.definition.CategoryBean;

public class CategoryControllerTest {

	@InjectMocks
    CategoryService categoryService;
    
    @Mock
    private CategoryRepository categoryRepository;
    
    @Mock
    private CategoryFactory categoryFactory;
    
    @Test
    public void findAll() {
    	List<CategoryBean> result = categoryService.findAll(1L);
    	assertTrue(!result.isEmpty());
    }
}
