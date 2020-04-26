package lk.nasi.CategoryService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nasi.CategoryService.model.Category;
import lk.nasi.CategoryService.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	CategoryRepository repository;
	@Override
	public List<Category> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Category insert(Category category) {
		// TODO Auto-generated method stub
		return repository.save(category);
	}

}
