package lk.nasi.shoppingCartService.service;

import java.util.List;
import java.util.Optional;

import lk.nasi.shoppingCartService.model.Item;
import lk.nasi.shoppingCartService.model.shoppingCart;

public interface shoppingCartService {
	
	Optional<shoppingCart> getShoppingCart(int id);
	
	void deleteCart(int id);
	
	shoppingCart createCart(long date);
	
	Optional<Item> getItem(Integer id);
	
	Item deleteItem(Integer id);

	Item createOrUpdateItem(Item item, Integer cartId,Integer change);

	//int updateQuantity(int quantity, int item_id);
	List<Item> getAllReleventItems(int id);
	

}
