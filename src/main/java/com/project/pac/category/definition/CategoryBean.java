package com.project.pac.category.definition;

import com.project.pac.categorytype.definition.CategoryType;

import lombok.Data;

@Data
public class CategoryBean {

	private Long id;
	private Long idUser;
	private String description;
	private String name;
	private CategoryType type;
}
