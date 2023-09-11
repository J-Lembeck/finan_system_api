package com.project.pac.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.category.definition.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

	List<CategoryModel> findAllByIdUser(Long userId);

}
