import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager(scanner);

        while (true) {
            System.out.println("1. Add product");
            System.out.println("2. Display products");
            System.out.println("3. Search product by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.addProduct();
                    break;
                case 2:
                    manager.displayProducts();
                    break;
                case 3:
                    manager.searchProduct();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}


