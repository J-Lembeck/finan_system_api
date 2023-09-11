package com.project.pac;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.project.pac.categorytype.CategoryTypeFactory;
import com.project.pac.categorytype.CategoryTypeRepository;
import com.project.pac.categorytype.CategoryTypeService;
import com.project.pac.categorytype.definition.CategoryTypeBean;

public class CategoryTypeControllerTest {

	@InjectMocks
    CategoryTypeService categoryTypeService;
    
    @Mock
    private CategoryTypeRepository categoryTypeRepository;
    
    @Mock
    private CategoryTypeFactory categoryTypeFactory;
    
    @Test
    public void findAll() {
    	List<CategoryTypeBean> result = categoryTypeService.findAll();
    	assertTrue(!result.isEmpty());
    }
}
