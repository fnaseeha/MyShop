package lk.nasi.orderService.model;

public class CustomItem {

	int quantity;
	String product_title;
	String product_price;
	String product_category;
	String product_imageUrl;
	
	
	public CustomItem() {
		
	}
	



	public CustomItem( int quantity,String product_title, String product_price, String product_category,
			String product_imageUrl) {
		
		this.quantity = quantity;
		this.product_title = product_title;
		this.product_price = product_price;
		this.product_category = product_category;
		this.product_imageUrl = product_imageUrl;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_imageUrl() {
		return product_imageUrl;
	}
	public void setProduct_imageUrl(String product_imageUrl) {
		this.product_imageUrl = product_imageUrl;
	}
	
	
	
}
