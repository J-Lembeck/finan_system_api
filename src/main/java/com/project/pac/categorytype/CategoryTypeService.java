package com.project.pac.categorytype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.categorytype.definition.CategoryTypeBean;

@Service
public class CategoryTypeService {

	@Autowired
	CategoryTypeRepository categoryTypeRepository;

	public List<CategoryTypeBean> findAll() {
		return new CategoryTypeFactory().buildBeanList(categoryTypeRepository.findAll());
	}

	public CategoryTypeBean findById(Long id) {
		return new CategoryTypeFactory().buildBean(categoryTypeRepository.findById(id).get());
	}
}
