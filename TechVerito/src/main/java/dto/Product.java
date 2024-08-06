package main.java.dto;

public class Product {

	private String name;
	private double price;
	private ProductType type;
	private int quantity;
	
	public Product(String name, double price, ProductType type, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void decreaseQuantity() {
		quantity-=1;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", type=" + type + ", quantity=" + quantity + "]";
	}
	
	
}
