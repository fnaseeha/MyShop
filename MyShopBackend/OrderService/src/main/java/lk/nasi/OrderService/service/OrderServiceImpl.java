package lk.nasi.orderService.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import lk.nasi.orderService.model.Item;
import lk.nasi.orderService.model.myOrder;
import lk.nasi.orderService.repository.itemRepository;
import lk.nasi.orderService.repository.OrderServiceRepository;

@Service
public class OrderServiceImpl implements OrderService{
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	OrderServiceRepository myOrderRepository;
	
	@Autowired
	itemRepository itemRepository;
	

	@Transactional
	@Override
	public myOrder create(myOrder myorder) {
//		if(myorder.getItems().size()>0){
//			for(Item m : myorder.getItems()){
//				Item a =insertItem(m,myorder.getId());
//			}
//		}
		
		return myOrderRepository.save(myorder);
	}


	@Override
	public List<myOrder> getAll() {
		return myOrderRepository.findAll();
	}

	@Override
	public List<myOrder> getMyOrder(int id) {
		
		return myOrderRepository.findByUserId(id);
	}

	

	public Item insertItem(Item item,int orderID){
		Optional<myOrder> s = myOrderRepository.findById(orderID);
		item.setMyOrder(s.get());
		return itemRepository.save(item);
	}


	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	

	
}
