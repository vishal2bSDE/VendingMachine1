package main.java.dto;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

	private String name;
	private List<Product> products;
	public VendingMachine(String name) {
		super();
		this.name = name;
		products=new ArrayList();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void addProduct(Product product) {
		products.add(product);
	}
}
