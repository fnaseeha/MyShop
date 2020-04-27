package lk.nasi.orderService.service;

import java.util.List;
import java.util.Optional;

import lk.nasi.orderService.model.Item;
import lk.nasi.orderService.model.myOrder;

public interface OrderService {
	

	myOrder create(myOrder myorder);
	
	List<myOrder> getAll();
	
	List<myOrder> getMyOrder(int id);
	
	List<Item> getAllItems();
	

}
