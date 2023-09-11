package com.project.pac.categorytype;

import java.util.List;

import org.springframework.stereotype.Component;

import com.project.pac.categorytype.definition.CategoryTypeBean;
import com.project.pac.categorytype.definition.CategoryTypeModel;

@Component
public class CategoryTypeFactory {

	public List<CategoryTypeBean> buildBeanList(List<CategoryTypeModel> listModel) {
		return listModel.stream().map(this::buildBean).toList();
	}

	public CategoryTypeBean buildBean(CategoryTypeModel model) {
		CategoryTypeBean bean = new CategoryTypeBean();

		bean.setId(model.getId());
		bean.setDescription(model.getDescription());

		return bean;
	}
}
