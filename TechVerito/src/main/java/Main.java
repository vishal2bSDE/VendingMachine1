package main.java;

import java.util.List;

import main.java.dto.Coin;
import main.java.dto.Product;
import main.java.dto.ProductType;
import main.java.service.VendingMachineService;
//1. Design a vending machine. It should have at least three types of products.
//2. Users should be able to insert coins of various denominations (e.g. 1, 5, 10, 25 cents) to buy product.
//3. Users should be able to select a product and the vending
//machine should dispense the product if the user has inserted enough money.
//4. If the inserted coin amounts to more than the price of product then return the change
public class Main {

	private static VendingMachineService vendingService;
	public static void main(String[] args) {
		System.out.println("TechVerito app started");
//		List<String> list=new ArrayList();
//		list.add("a");
//		list.stream().forEach(System.out::println);
		
		vendingService = new VendingMachineService("VendingMachine1");
		
		Product p1 = new Product("p1", 2.0, ProductType.ONE, 2);
		Product p2 = new Product("p2", 2.0, ProductType.TWO, 2);
		Product p3 = new Product("p3", 2.0, ProductType.THREE, 2);
		vendingService.addProduct(p1);
		vendingService.addProduct(p2);
		vendingService.addProduct(p3);
		
		System.out.println(vendingService.getAllProucts());
		
		vendingService.dispenceProduct(List.of(Coin.TEN), ProductType.ONE);
		
	}
}
