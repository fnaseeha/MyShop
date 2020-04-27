package lk.nasi.orderService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class myOrder {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	long dateCreated;
	int user_id;
	String ship_name;
	String ship_addressLine1;
	String ship_addressLine2;
	String ship_city;
	String total;
	
	@OneToMany(mappedBy="myOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	List<Item> items;
	
	public myOrder(){}

//	public myOrder( long dateCreated, int user_id, String ship_name, String ship_addressLine1,
//			String ship_addressLine2, String ship_city, String total) {
//		
//		this.dateCreated = dateCreated;
//		this.user_id = user_id;
//		this.ship_name = ship_name;
//		this.ship_addressLine1 = ship_addressLine1;
//		this.ship_addressLine2 = ship_addressLine2;
//		this.ship_city = ship_city;
//		this.total = total;
//	}

	
	public myOrder(long dateCreated, int user_id, String ship_name, String ship_addressLine1, String ship_addressLine2,
			String ship_city, String total, List<Item> items) {
		super();
		this.dateCreated = dateCreated;
		this.user_id = user_id;
		this.ship_name = ship_name;
		this.ship_addressLine1 = ship_addressLine1;
		this.ship_addressLine2 = ship_addressLine2;
		this.ship_city = ship_city;
		this.total = total;
		this.items = items;
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public long getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(long dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
