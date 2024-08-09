package main.java.com.library.service;

import main.java.com.library.model.Book;
import main.java.com.library.repository.BookRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(Connection connection) {
        this.bookRepository = new BookRepository(connection);
    }

    public void addBook(Book book) throws SQLException {
        bookRepository.addBook(book);
    }

    public Book getBookById(int id) throws SQLException {
        return bookRepository.getBookById(id);
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookRepository.getAllBooks();
    }

    public void updateBook(Book book) throws SQLException {
        bookRepository.updateBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        bookRepository.deleteBook(id);
    }
}
