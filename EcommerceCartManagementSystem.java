package ecommercecart;

import java.util.Scanner;

public class EcommerceCartManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        // Sample products
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);
        Product product3 = new Product("Headphones", 199.99);
        Product product4 = new Product("EarBuds", 200.99);

        // Displaying the  available products
        System.out.println("Available Products:");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Laptop to cart");
            System.out.println("2. Add Smartphone to cart");
            System.out.println("3. Add Headphones to cart");
            System.out.println("4. Add EarBuds to cart");
            System.out.println("5. View Cart");
            System.out.println("6. Remove Product from Cart");
            System.out.println("7. Checkout");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity: ");
                    int quantity1 = scanner.nextInt();
                    cart.addProduct(product1, quantity1);
                    break;
                case 2:
                    System.out.print("Enter quantity: ");
                    int quantity2 = scanner.nextInt();
                    cart.addProduct(product2, quantity2);
                    break;
                case 3:
                    System.out.print("Enter quantity: ");
                    int quantity3 = scanner.nextInt();
                    cart.addProduct(product3, quantity3);
                    break;
                case 4:
                    System.out.print("Enter quantity: ");
                    int quantity4 = scanner.nextInt();
                    cart.addProduct(product4, quantity4);
                    break;
                case 5:
                    cart.viewCart();
                    break;
                case 6:
                    System.out.print("Enter product name to remove (Laptop, Smartphone, Headphones): ");
                    String productName = scanner.next();
                    if (productName.equalsIgnoreCase("Laptop")) {
                        cart.removeProduct(product1);
                    } else if (productName.equalsIgnoreCase("Smartphone")) {//compares two strings
                        cart.removeProduct(product2);
                    } else if (productName.equalsIgnoreCase("Headphones")) {
                        cart.removeProduct(product3);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 7:
                    double total = cart.checkout();
                    System.out.println("Total amount: "+ total);
                    System.out.println("Thank you for your purchase!");
                    break;
                case 8:
                    System.out.println("Thank you! Visit Again...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}