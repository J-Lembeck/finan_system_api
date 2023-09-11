package com.project.pac.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.category.definition.CategoryBean;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping(path = "/findAll")
	public List<CategoryBean> findAll(@RequestParam("userId") Long userId) {
		return categoryService.findAll(userId);
	}

	@PostMapping
	public List<CategoryBean> saveAll(@RequestBody List<CategoryBean> categoryList) {
		return categoryService.saveAll(categoryList);
	}

	@PutMapping
	public CategoryBean update(@RequestBody CategoryBean category) throws Exception {
		return categoryService.update(category);
	}

	@DeleteMapping
	public void deleteByIdsIn(@RequestParam("ids") List<Long> cateogoryIds) throws Exception {
		categoryService.deleteByIds(cateogoryIds);
	}
}
