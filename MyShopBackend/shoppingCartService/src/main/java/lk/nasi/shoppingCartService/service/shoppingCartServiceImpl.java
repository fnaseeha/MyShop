package lk.nasi.shoppingCartService.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import lk.nasi.shoppingCartService.model.Item;
import lk.nasi.shoppingCartService.model.shoppingCart;
import lk.nasi.shoppingCartService.repository.itemRepository;
import lk.nasi.shoppingCartService.repository.shoppingCartRepository;

@Service
public class shoppingCartServiceImpl implements shoppingCartService{
	Logger logger = LoggerFactory.getLogger(shoppingCartServiceImpl.class);
	
	@Autowired
	shoppingCartRepository cartRepository;
	
	@Autowired
	itemRepository itemRepository;
	
	@Override
	public Optional<shoppingCart> getShoppingCart(int id) {
		List<Item> items = itemRepository.getAllReleventItems(id);
		Optional<shoppingCart> s =  cartRepository.findById(id);
		s.get().setItems(items);
		return s;
	}
	
	public List<Item> getAllReleventItems(int id){
		return itemRepository.getAllReleventItems(id);
	}

	@Transactional
	@Override
	public void deleteCart(int id) {
		List<Item> items = itemRepository.getAllReleventItems(id);
		if(items.size()>0){
			for(Item item:items){
				logger.info("item ",item);
				deleteItem(item.getId());
			}
		}
		//itemRepository.deleteAllReleventItems(id);
		//cartRepository.deleteById(id);
	}

	@Override
	public shoppingCart createCart(long date) {
		shoppingCart s = new shoppingCart(date);
		return cartRepository.save(s);
	}

	@Override
	public Optional<Item> getItem(Integer itemId) {	
		
		return itemRepository.findById(itemId);
	}

	@Transactional
	@Override
	public Item createOrUpdateItem(Item item,Integer cartId,Integer change) {
		
		Optional<Item> i = itemRepository.existItem(item.getTitle(),cartId);
		if(i.isPresent()){
			int q = i.get().getQuantity()+change;
			logger.info("q is >>>"+q);
			if(q>0){
				//update
				i.get().setQuantity(q);
				return itemRepository.save(i.get());
				
			}else{
				//delete
				logger.info("delete id >>>"+i.get().getId());
				 itemRepository.deleteById(i.get().getId());
				 return i.get();
			}
			
		}else{
			//insert
			Optional<shoppingCart> s = cartRepository.findById(cartId);
			item.setShoppingCart(s.get());
			return itemRepository.save(item);
		}
	}

	@Override
	public Item deleteItem(Integer id) {
		Optional<Item> i = itemRepository.findById(id);
		if(i.isPresent()){
			Item k = i.get();
			k.setShoppingCart(null);
			itemRepository.delete(k);
			return k;
		}
		return null;
	}

//	@Override
//	public int updateQuantity(int quantity, int item_id) {
//		// TODO Auto-generated method stub
//		return itemRepository.updateQuantity(quantity,item_id);
//	}

	

	

	
}
