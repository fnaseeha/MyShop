package lk.nasi.ProductService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.nasi.ProductService.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
