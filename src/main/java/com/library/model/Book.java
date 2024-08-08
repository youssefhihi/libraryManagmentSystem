package main.java.com.library.model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String ISBN;
    private int quantity;


    public Book(int id, String title, String author, String ISBN, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getISBN() {
        return ISBN;

    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;

    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
