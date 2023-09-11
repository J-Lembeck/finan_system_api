package com.project.pac.category;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.pac.category.definition.CategoryBean;
import com.project.pac.category.definition.CategoryModel;

@Component
public class CategoryFactory {

	public List<CategoryBean> buildBeanList(List<CategoryModel> listModel) {
		return listModel.stream().map(this::buildBean).toList();
	}

	public CategoryBean buildBean(CategoryModel model) {
		CategoryBean bean = new CategoryBean();

		bean.setId(model.getId());
		bean.setIdUser(model.getIdUser());
		bean.setName(model.getName());
		bean.setDescription(model.getDescription());
		bean.setType(model.getType());

		return bean;
	}

	public CategoryModel buildModel(CategoryBean bean) {
		CategoryModel model = new CategoryModel();

		model.setId(bean.getId());
		model.setIdUser(bean.getIdUser());
		model.setName(bean.getName());
		model.setDescription(bean.getDescription());
		model.setType(bean.getType());

		return model;
	}
}
