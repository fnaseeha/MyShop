package lk.nasi.ProductService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nasi.ProductService.model.Product;
import lk.nasi.ProductService.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repository;
	
	@Override
	public Product createOrUpdate(Product products) {
		return repository.save(products);
	}

	@Override
	public List<Product> getAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Product> get(int productId) {
		return repository.findById(productId);
	}

	@Override
	public void delete(int productId) {
		 repository.deleteById(productId);
	}

}
