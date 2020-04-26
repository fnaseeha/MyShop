package lk.nasi.shoppingCartService.model;

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
	
	String imageUrl;
	int price;
	int quantity;
	String title;
	
	
	@ManyToOne
	@JoinColumn(name="shoppingCart_id")
	shoppingCart shoppingCart;
	
	@JsonIgnore
	public shoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(shoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPrice() {
		return price;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", imageUrl=" + imageUrl + ", price=" + price + ", quantity=" + quantity + ", title="
				+ title + ", shoppingCart=" + shoppingCart + "]";
	}
	
	
	
}
