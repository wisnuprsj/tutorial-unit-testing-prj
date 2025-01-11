package id.co.wisnuprsj.librarymanagement.repository;

import id.co.wisnuprsj.librarymanagement.repository.model.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBook();
    Book getBookByBookId(String bookId) throws EmptyResultDataAccessException;
    List<Book> getBookByTitle(String title);
    List<Book> getBookByAuthor(String author);
    List<Book> getBookByIsbn(String isbn);
    List<Book> getBookByPublisher(String publisher);
    List<Book> getBookByTitleAndAuthor(String title, String author);
    List<Book> getBookByTitleOrAuthor(String title, String author);
    void addBook(Book book);
    void deleteBook(String bookId);
    void updateBook(Book book) throws DataAccessException;

}
