package com.project.pac.categorytype;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.categorytype.definition.CategoryTypeModel;

public interface CategoryTypeRepository extends JpaRepository<CategoryTypeModel, Long> {

}
