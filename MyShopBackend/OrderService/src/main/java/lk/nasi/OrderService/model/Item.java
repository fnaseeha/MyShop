package lk.nasi.orderService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	int product_id;
	int quantity;
	double price;
	
	
	@ManyToOne
	@JoinColumn(name="myOrder_id")
	myOrder myOrder;
	
//	public myOrder getShoppingCart() {
//		return myOrder;
//	}
//	public void setShoppingCart(myOrder myOrder) {
//		this.myOrder = myOrder;
//	}
	
	
	@JsonIgnore
	public myOrder getMyOrder() {
		return myOrder;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setMyOrder(myOrder myOrder) {
		this.myOrder = myOrder;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", product_id=" + product_id + ", quantity=" + quantity + ", price=" + price
				+ ", myOrder=" + myOrder + "]";
	}
	
	
	
	
}
