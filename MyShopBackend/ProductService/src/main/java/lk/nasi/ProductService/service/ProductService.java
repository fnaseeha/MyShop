package lk.nasi.ProductService.service;

import java.util.List;
import java.util.Optional;

import lk.nasi.ProductService.model.Product;

public interface ProductService {

	Product createOrUpdate(Product products);
		  
	List<Product> getAll();

	Optional<Product> get(int productId);

	
	void delete(int productId);
}
