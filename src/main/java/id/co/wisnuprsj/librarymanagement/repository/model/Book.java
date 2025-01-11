package id.co.wisnuprsj.librarymanagement.repository.model;

import id.co.wisnuprsj.librarymanagement.model.request.BookRq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String publisher;

    public void constructBook(BookRq bookRq) {
        this.bookId = UUID.randomUUID().toString();
        this.title = bookRq.getTitle();
        this.author = bookRq.getAuthor();
        this.isbn = bookRq.getIsbn();
        this.publisher = bookRq.getPublisher();
    }

}
