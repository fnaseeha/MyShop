package lk.nasi.orderService.model;

public class Product {
	
	int id;
	String title;
	String price;
	String category;
	String imageUrl;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", category=" + category + ", imageUrl="
				+ imageUrl + "]";
	}
	
	
	
	
}
