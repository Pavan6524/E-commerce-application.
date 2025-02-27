package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ECommerceApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Category> categories = new ArrayList<>();
    private static final List<Product> cart = new ArrayList<>();
    private static String customerName;

    public static void main(String[] args) {
        setupCategories();
        System.out.println("Welcome to E-Commerce App!");
        System.out.print("Please enter your name: ");
        customerName = scanner.nextLine();
        displayCategories();

        while (true) {
            System.out.println("Enter category number to view subcategories, 'v' to view cart, 'r' to remove item from cart, or 'q' to quit and generate bill:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                generateBill();
                break;
            } else if (input.equalsIgnoreCase("v")) {
                viewCart();
            } else if (input.equalsIgnoreCase("r")) {
                removeFromCart();
            } else {
                try {
                    int categoryIndex = Integer.parseInt(input) - 1;
                    if (categoryIndex >= 0 && categoryIndex < categories.size()) {
                        displaySubcategories(categoryIndex);
                    } else {
                        System.out.println("Invalid category number. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
        }
    }

    private static void setupCategories() {
        Category fashion = new Category("Fashion");

        Subcategory men = new Subcategory("Men");
        men.addProduct(new Product("Shirt", 20.99));
        men.addProduct(new Product("Jeans", 45.99));

        Subcategory women = new Subcategory("Women");
        women.addProduct(new Product("Dress", 50.99));
        women.addProduct(new Product("Handbag", 75.99));

        Subcategory boys = new Subcategory("Boys");
        boys.addProduct(new Product("Shirt", 15.99));
        boys.addProduct(new Product("Shorts", 25.99));

        Subcategory girls = new Subcategory("Girls");
        girls.addProduct(new Product("Skirt", 20.99));
        girls.addProduct(new Product("Doll", 30.99));

        fashion.addSubcategory(men);
        fashion.addSubcategory(women);
        fashion.addSubcategory(boys);
        fashion.addSubcategory(girls);

        Category electronics = new Category("Electronics");
        Subcategory computer= new Subcategory("Computer Accessories");
        computer.addProduct(new Product("Laptop", 999.99));
        computer.addProduct(new Product("Desktop",150.99));
        computer.addProduct(new Product("Tablet", 99.40));
        computer.addProduct(new Product("Mouse",20.99));
        computer.addProduct(new Product("KeyBoard",49.99));
        computer.addProduct(new Product("Router",30.99));
        Subcategory m= new Subcategory("Mobile Access");
        m.addProduct(new Product("Charger",30.00));
        m.addProduct(new Product("Headphones", 199.99));
        m.addProduct(new Product(" Mobile Holder",10.00));
        m.addProduct(new Product("Mobile case ",15.99));
        m.addProduct(new Product("Ear Pods",90.00));
        m.addProduct(new Product("Screen guards",49.99));
        
        electronics.addSubcategory(computer);
        electronics.addSubcategory(m);

        Category mobiles = new Category("Mobiles");
        Subcategory apple = new Subcategory("Apple");
        apple.addProduct(new Product("15 Pro Max", 1499.99));
        apple.addProduct(new Product("15 Plus", 1299.99));
        apple.addProduct(new Product("15 Pro", 1099.99));
        apple.addProduct(new Product("Iphone 15", 999.99));
        apple.addProduct(new Product("15 mini", 599.99));
        apple.addProduct(new Product("14 Pro Max", 1399.99));
        Subcategory samsung = new Subcategory("Samsung");
        samsung.addProduct(new Product("S21 Ultra",999.000));
        samsung.addProduct(new Product("S21 Ultra",999.000));
        samsung.addProduct(new Product("S21 Ultra",999.000));
        samsung.addProduct(new Product("S22 Ultra",999.000));
        samsung.addProduct(new Product("S23 Ultra",999.000));
        samsung.addProduct(new Product("S24 Ultra",999.000));
        Subcategory redmi = new Subcategory("Redmi");
        redmi.addProduct(new Product("Redmi Note 8 Pro Max",159.000));
        redmi.addProduct(new Product("Redmi Note 9 Pro Max",169.000));
        redmi.addProduct(new Product("Redmi Note 10 Pro Max",109.000));
        redmi.addProduct(new Product("Redmi Note 11 Pro Max",179.000));
        redmi.addProduct(new Product("Redmi Note 12 Pro Max",200.000));
        mobiles.addSubcategory(apple);
        mobiles.addSubcategory(samsung);
        mobiles.addSubcategory(redmi);
        categories.add(fashion);
        categories.add(electronics);
        categories.add(mobiles);
    }
    private static void displayCategories() {
        System.out.println("Available Categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
    }

    private static void displaySubcategories(int categoryIndex) {
        Category category = categories.get(categoryIndex);
        System.out.println("Subcategories in " + category.getName() + ":");
        List<Subcategory> subcategories = category.getSubcategories();
        for (int i = 0; i < subcategories.size(); i++) {
            System.out.println((i + 1) + ". " + subcategories.get(i).getName());
        }

        System.out.println("Enter subcategory number to view products or 'b' to go back:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("b")) {
            return;
        }
        try {
            int subcategoryIndex = Integer.parseInt(input) - 1;
            if (subcategoryIndex >= 0 && subcategoryIndex < subcategories.size()) {
                displayProducts(categoryIndex, subcategoryIndex);
            } else {
                System.out.println("Invalid subcategory number. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    private static void displayProducts(int categoryIndex, int subcategoryIndex) {
        Category category = categories.get(categoryIndex);
        Subcategory subcategory = category.getSubcategories().get(subcategoryIndex);
        System.out.println("Products in " + subcategory.getName() + ":");
        List<Product> products = subcategory.getProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println("Enter product number to add to cart or 'b' to go back:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("b")) {
            return;
        }

        try {
            int productIndex = Integer.parseInt(input) - 1;
            if (productIndex >= 0 && productIndex < products.size()) {
                cart.add(products.get(productIndex));
                System.out.println(products.get(productIndex).getName() + " added to cart.");
            } else {
                System.out.println("Invalid product number. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    private static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i));
            }
        }
    }
    private static void removeFromCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        viewCart();
        System.out.println("Enter the item number to remove from cart or 'b' to go back:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("b")) {
            return;
        }
        try {
            int itemIndex = Integer.parseInt(input) - 1;
            if (itemIndex >= 0 && itemIndex < cart.size()) {
                System.out.println(cart.get(itemIndex).getName() + " removed from cart.");
                cart.remove(itemIndex);
            } else {
                System.out.println("Invalid item number. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
    private static void generateBill() {
        System.out.println("\n--- Bill To be Paid---");
        System.out.println("Customer Name: " + customerName);
        double total = 0;
        for (Product product : cart) {
            System.out.println(product);
            total += product.getPrice();
        }
        System.out.println("Total: $" + total);
        System.out.println("-------------------------------");
    }
}
