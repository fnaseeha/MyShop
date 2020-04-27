package lk.nasi.orderService.model;

import java.util.List;

public class CustomMyOrder {
	
	int order_id;
	int user_id;
	String ship_name;
	String ship_addressLine1;
	String ship_addressLine2;
	String ship_city;
	List<CustomItem> customItem;
	
	
	public CustomMyOrder() {
	}
	public CustomMyOrder(int order_id, int user_id, String ship_name, String ship_addressLine1,
			String ship_addressLine2, String ship_city, List<CustomItem> customItem) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.ship_name = ship_name;
		this.ship_addressLine1 = ship_addressLine1;
		this.ship_addressLine2 = ship_addressLine2;
		this.ship_city = ship_city;
		this.customItem = customItem;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getShip_name() {
		return ship_name;
	}
	public void setShip_name(String ship_name) {
		this.ship_name = ship_name;
	}
	public String getShip_addressLine1() {
		return ship_addressLine1;
	}
	public void setShip_addressLine1(String ship_addressLine1) {
		this.ship_addressLine1 = ship_addressLine1;
	}
	public String getShip_addressLine2() {
		return ship_addressLine2;
	}
	public void setShip_addressLine2(String ship_addressLine2) {
		this.ship_addressLine2 = ship_addressLine2;
	}
	public String getShip_city() {
		return ship_city;
	}
	public void setShip_city(String ship_city) {
		this.ship_city = ship_city;
	}
	public List<CustomItem> getCustomItem() {
		return customItem;
	}
	public void setCustomItem(List<CustomItem> customItem) {
		this.customItem = customItem;
	}

	
	

}
