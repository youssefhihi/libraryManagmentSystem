package main.java.com.library.ui;
import main.java.com.library.model.Book;
import main.java.com.library.service.BookService;
import main.java.com.library.utils.database.connectDB;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class bookUI {

    private BookService bookService;
    private Connection connection;
    public bookUI() {
        Connection connection = connectDB.getConnection();
        if (connection != null) {
            bookService = new BookService(connection);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nBooks Management Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Get Book by ID");
            System.out.println("3. Get All Books");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    getBookById(scanner);
                    break;
                case 3:
                    getAllBooks();
                    break;
                case 4:
                    updateBook(scanner);
                    break;
                case 5:
                    deleteBook(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the the books management.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String ISBN = scanner.nextLine();


        Book book = new Book(0, title, author, ISBN, quantity);
        try {
            bookService.addBook(book);
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding book.");
            e.printStackTrace();
        }
    }

    private void getBookById(Scanner scanner) {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        try {
            Book book = bookService.getBookById(id);
            if (book != null) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor() + "quantity : " + book.getQuantity()) ;
            } else {
                System.out.println("No book found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving book.");
            e.printStackTrace();
        }
    }

    private void getAllBooks() {
        try {
            List<Book> books = bookService.getAllBooks();
            if (books.isEmpty()) {
                System.out.println("No books found.");
            } else {
                System.out.println("Books in the library:");
                for (Book book : books) {
                    System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor()+ "quantity : " + book.getQuantity());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving books.");
            e.printStackTrace();
        }
    }

    private void updateBook(Scanner scanner) {
        System.out.print("Enter book ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new ISBN: ");
        String ISBN = scanner.nextLine();

        Book book = new Book(id, title, author,ISBN,quantity);
        try {
            bookService.updateBook(book);
            System.out.println("Book updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating book.");
            e.printStackTrace();
        }
    }

    private void deleteBook(Scanner scanner) {
        System.out.print("Enter book ID to delete: ");
        int id = scanner.nextInt();
        try {
            bookService.deleteBook(id);
            System.out.println("Book deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting book.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        bookUI app = new bookUI();
        app.run();
    }
}