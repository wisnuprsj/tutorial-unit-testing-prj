package id.co.wisnuprsj.librarymanagement.usecase;

import id.co.wisnuprsj.librarymanagement.model.general.BaseResponse;
import id.co.wisnuprsj.librarymanagement.model.request.BookRq;
import id.co.wisnuprsj.librarymanagement.repository.model.Book;
import id.co.wisnuprsj.librarymanagement.repository.BookRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookUsecase {

    private final BookRepository bookRepository;

    public BookUsecase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BaseResponse<List<Book>> getAllBook() {
        BaseResponse<List<Book>> response = new BaseResponse<>();
        List<Book> books = this.bookRepository.getAllBook();
        response.setOk(books);
        return response;
    }

    public BaseResponse<Book> getBookByBookId(String bookId) {
        BaseResponse<Book> response = new BaseResponse<>();
        Book book = null;
        try {
            book = this.bookRepository.getBookByBookId(bookId);
        } catch (EmptyResultDataAccessException e) {
            response.setFailed("No records found");
        }

        response.setOk(book);
        return response;
    }

    public BaseResponse<Book> createBook(BookRq book) {
        BaseResponse<Book> response = new BaseResponse<>();

        List<Book> existingBook = this.bookRepository.getBookByTitle(book.getTitle());
        if (!existingBook.isEmpty()) {
            response.setFailed("The title already exist in our library");
            return response;
        }

        try {
            Book newBook = new Book();
            newBook.constructBook(book);
            this.bookRepository.addBook(newBook);
            response.setOk(newBook);
        } catch (Exception e) {
            response.setError(HttpStatus.BAD_REQUEST, "Failed to create book");
        }
        return response;
    }

    public BaseResponse<String> updateBook(BookRq book) {
        BaseResponse<String> response = new BaseResponse<>();
        Book existingBook;
        try {
            existingBook = this.bookRepository.getBookByBookId(book.getBookId());
        } catch (EmptyResultDataAccessException e) {
            response.setFailed("Book not found");
            return response;
        }

        existingBook.constructBook(book);
        this.bookRepository.updateBook(existingBook);
        response.setOk("Book updated successfully");
        return response;
    }

    public BaseResponse<String> deleteBook(String bookId) {
        BaseResponse<String> response = new BaseResponse<>();
        Book existingBook;
        try {
            existingBook = this.bookRepository.getBookByBookId(bookId);
        } catch (EmptyResultDataAccessException e) {
            response.setFailed("Book not found");
            return response;
        }

        this.bookRepository.deleteBook(existingBook.getBookId());
        response.setOk("Book deleted successfully");
        return response;
    }

}
