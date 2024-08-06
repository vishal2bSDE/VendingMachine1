package main.java.dto;

public enum Coin {
	ONE(1.0), FIVE(5.0), TEN(10.0), TWENTY_FIVE(25.0);
	
	double value;
	Coin(double d) {
		value=d;
	}
	public double getValue() {
		return value;
	}
	
}
