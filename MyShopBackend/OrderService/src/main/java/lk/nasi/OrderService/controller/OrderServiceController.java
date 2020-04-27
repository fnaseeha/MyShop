package lk.nasi.orderService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lk.nasi.orderService.model.CustomItem;
import lk.nasi.orderService.model.CustomMyOrder;
import lk.nasi.orderService.model.Item;
import lk.nasi.orderService.model.Product;
import lk.nasi.orderService.model.myOrder;
import lk.nasi.orderService.service.OrderService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class OrderServiceController {

	@Autowired
	OrderService service;
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
	  return new RestTemplate();
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public myOrder createCart(@RequestBody myOrder myorder) {
		return service.create(myorder);
	}
	
	@RequestMapping(value="/getOrder",method=RequestMethod.GET)
	public List<myOrder> getAllOrder() {
		return service.getAll();
	}
	
	@RequestMapping(value="/getOrder/{id}",method=RequestMethod.GET)
	public List<myOrder> getMyOrder(@PathVariable int id) {
		return service.getMyOrder(id);
	}
	
	@RequestMapping(value="/getAllOrders",method=RequestMethod.GET)
	public List<CustomMyOrder> getAllOrderData(){
		
		
		
		List<myOrder> orders =service.getAll();
		
		List<CustomMyOrder> customMyOrder = new ArrayList<>();
		
		for(myOrder o : orders){
			List<CustomItem> customItems = new ArrayList<>();
			for(Item i : o.getItems()){
				Product p = this.restTemplate().getForObject("http://localhost:1990/product/"+i.getProduct_id(),Product.class);
				CustomItem c=  new CustomItem(i.getQuantity(),p.getTitle(), p.getPrice(),p.getCategory(),p.getImageUrl());
				customItems.add(c);
			}
			
			CustomMyOrder e= new CustomMyOrder(o.getId(),o.getUser_id(),o.getShip_name(),o.getShip_addressLine1(),
					o.getShip_addressLine2(),o.getShip_city(),customItems);
			customMyOrder.add(e);
		}
	
		return customMyOrder;
	}
	
}
