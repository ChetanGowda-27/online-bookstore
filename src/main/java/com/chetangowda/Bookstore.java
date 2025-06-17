import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    int id;
    String title;
    double price;
    Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    @Override
    public String toString() {
        return id + ". " + title + " ($" + price + ")";
    }
}

class Cart {
    private List<Book> items = new ArrayList<>();
    public void addBook(Book book) {
        items.add(book);
        System.out.println(book.title + " added to cart.");
    }
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("Cart Contents:");
            double total = 0;
            for (Book book : items) {
                System.out.println(book);
                total += book.price;
            }
            System.out.printf("Total: $%.2f%n", total);
        }
    }
}

public class Bookstore {
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "your_password"; // Replace with your MySQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            // Create books table
            stmt.execute("CREATE TABLE IF NOT EXISTS books (id INT PRIMARY KEY, title VARCHAR(100), price DOUBLE)");
            // Insert sample books
            stmt.executeUpdate("INSERT IGNORE INTO books VALUES (1, 'Java Programming', 29.99)");
            stmt.executeUpdate("INSERT IGNORE INTO books VALUES (2, 'Python Basics', 19.99)");
            stmt.executeUpdate("INSERT IGNORE INTO books VALUES (3, 'SQL Essentials', 24.99)");

            Scanner scanner = new Scanner(System.in);
            Cart cart = new Cart();
            while (true) {
                System.out.println("\n=== Online Bookstore ===");
                System.out.println("1. View Books");
                System.out.println("2. Add to Cart");
                System.out.println("3. View Cart");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice;
                try {
                    choice = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                    continue;
                }
                switch (choice) {
                    case 1:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM books");
                        System.out.println("\nAvailable Books:");
                        while (rs.next()) {
                            System.out.println(new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price")));
                        }
                        rs.close();
                        break;
                    case 2:
                        System.out.print("Enter book ID to add to cart: ");
                        int id;
                        try {
                            id = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid ID. Please enter a number.");
                            scanner.nextLine();
                            continue;
                        }
                        rs = stmt.executeQuery("SELECT * FROM books WHERE id = " + id);
                        if (rs.next()) {
                            cart.addBook(new Book(rs.getInt("id"), rs.getString("title"), rs.getDouble("price")));
                        } else {
                            System.out.println("Invalid book ID.");
                        }
                        rs.close();
                        break;
                    case 3:
                        cart.viewCart();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Choose 1-4.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}