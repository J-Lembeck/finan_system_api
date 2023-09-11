package com.project.pac.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.category.definition.CategoryBean;
import com.project.pac.category.definition.CategoryModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryFactory categoryFactory;

	public List<CategoryBean> findAll(Long userId) {
		List<CategoryModel> categoryModels = categoryRepository.findAllByIdUser(userId);
		return categoryModels.stream().map(categoryFactory::buildBean).collect(Collectors.toList());
	}

	public List<CategoryBean> saveAll(List<CategoryBean> categoryList) {
		return categoryList.stream().map(this::save).collect(Collectors.toList());
	}

	public CategoryBean save(CategoryBean categoryBean) {
		CategoryModel categoryModel = categoryFactory.buildModel(categoryBean);
		CategoryModel savedModel = categoryRepository.save(categoryModel);
		return categoryFactory.buildBean(savedModel);
	}

	public CategoryBean update(CategoryBean categoryBean) throws Exception {
		if (categoryRepository.existsById(categoryBean.getId())) {
			return save(categoryBean);
		} else {
			throw new Exception("Category not found");
		}
	}

	public void deleteByIds(List<Long> categoryIds) {
		categoryRepository.deleteAllById(categoryIds);
	}
}
