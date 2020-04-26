package lk.nasi.CategoryService.service;

import java.util.List;

import lk.nasi.CategoryService.model.Category;

public interface CategoryService {

	List<Category> getAll();
	
	Category insert(Category category);
}
