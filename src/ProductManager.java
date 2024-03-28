import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products;
    private final String FILENAME = "ListProduct.txt";
    private Scanner scanner;

    public ProductManager(Scanner scanner) {
        products = new ArrayList<>();
        this.scanner = scanner;
        loadProducts();
    }

    public void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter product brand: ");
        String brand = scanner.nextLine();
        Product product = new Product(id, name, price, brand);
        products.add(product);
        System.out.println("Product added successfully.");
        saveProducts();
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product.getId() + " , " + product.getName() + " , " +
                    product.getPrice() + " , " + product.getBrand());
        }
    }

    public void searchProduct() {
        System.out.println("Enter product ID to search:");
        String id = scanner.nextLine();
        boolean found = false;
        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.println(product.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

    private void loadProducts() {
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println("File does not exist. Creating new list.");
            return;
        }

        try (InputStream inputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            products = (List<Product>) objectInputStream.readObject();

        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    private void saveProducts() {
        File file = new File(FILENAME);
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(products);

        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }
}
