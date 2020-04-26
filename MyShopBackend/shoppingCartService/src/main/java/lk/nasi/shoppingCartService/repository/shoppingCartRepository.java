package lk.nasi.shoppingCartService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.nasi.shoppingCartService.model.shoppingCart;

@Repository
public interface shoppingCartRepository extends JpaRepository<shoppingCart, Integer> {

}
