package id.co.wisnuprsj.librarymanagement.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRq {

    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String publisher;

}
