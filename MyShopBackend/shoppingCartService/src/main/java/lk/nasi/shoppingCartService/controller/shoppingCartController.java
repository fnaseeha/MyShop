package lk.nasi.shoppingCartService.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.nasi.shoppingCartService.model.Item;
import lk.nasi.shoppingCartService.model.shoppingCart;
import lk.nasi.shoppingCartService.service.shoppingCartService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class shoppingCartController {

	@Autowired
	shoppingCartService service;
	
	@RequestMapping(value="/shopping-cart-create/{date}",method=RequestMethod.GET)
	public shoppingCart createCart(@PathVariable long date) {
		return service.createCart(date);
	}
	
	@RequestMapping(value="/shopping-cart/{id}",method=RequestMethod.GET)
	public Optional<shoppingCart> getShoppingCart(@PathVariable int id) {
		return service.getShoppingCart(id);
	}
	
	@RequestMapping(value="/shopping-cart-items/{id}",method=RequestMethod.GET)
	public List<Item> getAllReleventItems(@PathVariable int id) {
		return service.getAllReleventItems(id);
	}
	
	
	@RequestMapping(value="/shopping-cart/{id}",method=RequestMethod.DELETE)
	public void deleteCart(@PathVariable int id) {
		service.deleteCart(id);
	}
	
	//localhost:1992/shopping-cart-item/1 
	@RequestMapping(value="/shopping-cart-item/{id}/{change}",method=RequestMethod.POST)
	public Item createOrUpdateItem(@RequestBody Item item,@PathVariable Integer id,@PathVariable Integer change) {
		return service.createOrUpdateItem(item,id,change);
	}
	
//	int updateQuantity(@Param("quantity") int quantity, @Param("item_id") int item_id){
//		retrun service.updateQuantity(quantity, item_id);
//	}
	
	@RequestMapping(value="/shopping-cart-item/{id}",method=RequestMethod.GET)
	public Optional<Item> getItem(@PathVariable Integer id) {	
		return service.getItem(id);
	}

	//localhost:1992/shopping-cart-item/2
	@RequestMapping(value="/shopping-cart-item/{id}",method=RequestMethod.DELETE)
	public Item deleteItem(@PathVariable Integer id) {
		return service.deleteItem(id);
		
	}
}
