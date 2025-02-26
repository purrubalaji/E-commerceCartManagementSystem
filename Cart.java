package ecommercecart;

public class Cart {
    private Product[] products; // Array to store products
    private int[] quantities;    // Array to store quantities
    private int count;           // Number of products in the cart

    public Cart() {
        products = new Product[10]; // Initial capacity of 10
        quantities = new int[10];    // Initial capacity of 10
        count = 0;                   // Start with an empty cart
    }
    public void addProduct(Product product, int quantity) {
        // Check if the product is already in the cart
        for (int i = 0; i < count; i++) {
            if (products[i].equals(product)) {
                quantities[i] += quantity; // Increase quantity if product exists
                System.out.println(quantity + " x " + product.getName() + " has been added to the cart.");
                return;
            }
        }

        // If the product is not in the cart, add it
        if (count < products.length) {
            products[count] = product; // Add product to the array
            quantities[count] = quantity; // Set the quantity
            count++; // Increase the count of products
            System.out.println(quantity + " x " + product.getName() + " has been added to the cart.");
        } else {
            System.out.println("Cart is full. Cannot add more products.");
        }
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < count; i++) {
            if (products[i].equals(product)) {
                // Shift products and quantities to remove the product
                for (int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[count - 1] = null; // Clear the last product
                quantities[count - 1] = 0;   // Clear the last quantity
                count--; // Decrease the count of products
                System.out.println(product.getName() + " has been removed from the cart.");
                return;
            }
        }
        System.out.println("Product not found in the cart.");
    }

    public void viewCart() {
        if (count == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (int i = 0; i < count; i++) {
                System.out.println(products[i].getName() + " (Quantity: " + quantities[i] + ")");
            }
        }
    }

    public double checkout() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice() * quantities[i]; // Calculate total price
        }
        // Clear the cart after checkout
        products = new Product[10];
        quantities = new int[10];
        count = 0;
        return total; // Return the total price
    }
}