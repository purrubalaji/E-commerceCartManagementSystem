package ecommercecart;

import java.text.NumberFormat;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        // Format the price as currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return name + " - " + currencyFormat.format(price);
    }
}