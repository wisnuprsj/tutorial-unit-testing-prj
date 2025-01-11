package id.co.wisnuprsj.librarymanagement.repository.impl;

import id.co.wisnuprsj.librarymanagement.repository.model.Book;
import id.co.wisnuprsj.librarymanagement.repository.BookRepository;
import id.co.wisnuprsj.librarymanagement.repository.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static final String GET_ALL_BOOK = "SELECT * FROM book";
    private static final String GET_BOOK_BY_BOOKID = "SELECT * FROM book WHERE bookid = ?";
    private static final String GET_BOOK_BY_TITLE = "SELECT * FROM book WHERE title = ?";
    private static final String GET_BOOK_BY_AUTHOR = "SELECT * FROM book WHERE author = ?";
    private static final String GET_BOOK_BY_ISBN = "SELECT * FROM book WHERE isbn = ?";
    private static final String GET_BOOK_BY_PUBLISHER = "SELECT * FROM book WHERE publisher = ?";
    private static final String GET_BOOK_BY_TITLE_AND_AUTHOR = "SELECT * FROM book WHERE title = ? AND author = ?";
    private static final String GET_BOOK_BY_TITLE_OR_AUTHOR = "SELECT * FROM book WHERE title = ? OR author = ?";
    private static final String INSERT_BOOK = "INSERT INTO BOOK (bookid, title, author, isbn, publisher) VALUES (?,?,?,?,?)";
    private static final String DELETE_BOOK_BY_ID = "DELETE FROM BOOK WHERE bookid = ?";
    private static final String UPDATE_BOOK = "UPDATE BOOK SET title = ?, author = ?, isbn = ?, publisher = ? WHERE bookid = ?";


    @Autowired
    @Qualifier("jdbc-playground")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAllBook() {
        return jdbcTemplate.query(GET_ALL_BOOK, new BookRowMapper());
    }

    @Override
    public Book getBookByBookId(String bookId) throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject(GET_BOOK_BY_BOOKID, new BookRowMapper(), bookId);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        return jdbcTemplate.query(GET_BOOK_BY_TITLE, new BookRowMapper(), title);
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return jdbcTemplate.query(GET_BOOK_BY_AUTHOR, new BookRowMapper(), author);
    }

    @Override
    public List<Book> getBookByIsbn(String isbn) {
        return jdbcTemplate.query(GET_BOOK_BY_ISBN, new BookRowMapper(), isbn);
    }

    @Override
    public List<Book> getBookByPublisher(String publisher) {
        return jdbcTemplate.query(GET_BOOK_BY_PUBLISHER, new BookRowMapper(), publisher);
    }

    @Override
    public List<Book> getBookByTitleAndAuthor(String title, String author) {
        return jdbcTemplate.query(GET_BOOK_BY_TITLE_AND_AUTHOR, new BookRowMapper(), title, author);
    }

    @Override
    public List<Book> getBookByTitleOrAuthor(String title, String author) {
        return jdbcTemplate.query(GET_BOOK_BY_TITLE_OR_AUTHOR, new BookRowMapper(), title, author);
    }

    @Override
    public void addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK, book.getBookId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublisher());
    }

    @Override
    public void deleteBook(String bookId) {
        jdbcTemplate.update(DELETE_BOOK_BY_ID, bookId);
    }

    @Override
    public void updateBook(Book book) throws DataAccessException {
        jdbcTemplate.update(UPDATE_BOOK, book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublisher(), book.getBookId());
    }
}
