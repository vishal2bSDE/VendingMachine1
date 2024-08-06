package main.java.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.dto.Coin;
import main.java.dto.Product;
import main.java.dto.ProductType;
import main.java.dto.VendingMachine;

public class VendingMachineService {

	private VendingMachine machine;
	private Map<Coin, Integer> coinsChange;
	
	public VendingMachineService(String name) {
		machine=new VendingMachine(name);
		coinsChange=new HashMap();
		coinsChange.put(Coin.ONE, 10);
		coinsChange.put(Coin.FIVE, 10);
		coinsChange.put(Coin.TEN, 10);
		coinsChange.put(Coin.TWENTY_FIVE, 10);
	}
	
	public void addProduct(Product product) {
		machine.addProduct(product);
	}
	
	public List<Product> getAllProucts() {
		return machine.getProducts();
	}
	
	public void dispenceProduct(List<Coin> coinsInserted, ProductType productType) {
		double coinsSum = coinsInserted.stream().map(Coin::getValue).reduce(0.0, Double::sum);
		
		for(Product product : machine.getProducts()) {
			if(product.getType().equals(productType)) {
				if(product.getPrice()>coinsSum) {
					System.out.println("Provide more coin: "+(product.getPrice()-coinsSum));
					return;
				}
				System.out.println("Coins returned "+getTheChange(coinsSum-product.getPrice()));
				product.decreaseQuantity();
				System.out.println(product.getName()+" dispensed");
				return;
			}
		}
		
		System.out.println("Product Not Found : "+productType.toString());
	}

	private List<Coin> getTheChange(double change) {
		List<Coin> changeCoins = new ArrayList<>();
        List<Coin> denominations =  new ArrayList(coinsChange.keySet()); 
        Collections.sort(denominations, (c1, c2)->Double.compare(c2.getValue(), c1.getValue()));
        
        for (Coin denomination : denominations) {
        	double val=denomination.getValue();
            while (change >= val && coinsChange.get(denomination)>0) {
                changeCoins.add(denomination);
                coinsChange.put(denomination, coinsChange.get(denomination)-1);
                change -= val;
            }
        }

        return changeCoins;
	}
}
