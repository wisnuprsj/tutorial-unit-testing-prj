package id.co.wisnuprsj.librarymanagement.controller;

import id.co.wisnuprsj.librarymanagement.model.general.BaseResponse;
import id.co.wisnuprsj.librarymanagement.model.request.BookRq;
import id.co.wisnuprsj.librarymanagement.repository.model.Book;
import id.co.wisnuprsj.librarymanagement.usecase.BookUsecase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/book")
public class BookController {

    private final BookUsecase bookUsecase;

    public BookController(BookUsecase bookUsecase) {
        this.bookUsecase = bookUsecase;
    }

    @GetMapping(value = "/list", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<List<Book>>> getAllBooks(@RequestHeader(value = "ax-request-id", required = false) String requestId,
                                                                @RequestHeader(value = "ax-request-at", required = false) String requestAt,
                                                                HttpServletRequest request) {
        BaseResponse<List<Book>> response = this.bookUsecase.getAllBook();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping(value = "/{bookId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<Book>> getBookByBookId(@RequestHeader(value = "ax-request-id", required = false) String requestId,
                                                              @RequestHeader(value = "ax-request-at", required = false) String requestAt,
                                                              @PathVariable(value = "bookId") String bookId,
                                                              HttpServletRequest request) {
        BaseResponse<Book> response = this.bookUsecase.getBookByBookId(bookId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<Book>> createBook(@RequestHeader(value = "ax-request-id", required = false) String requestId,
                                                           @RequestHeader(value = "ax-request-at", required = false) String requestAt,
                                                           @RequestBody BookRq body,
                                                           HttpServletRequest request) {
        BaseResponse<Book> response = this.bookUsecase.createBook(body);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PatchMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<String>> updateBook(@RequestHeader(value = "ax-request-id", required = false) String requestId,
                                                           @RequestHeader(value = "ax-request-at", required = false) String requestAt,
                                                           @RequestBody BookRq body,
                                                           HttpServletRequest request) {
        BaseResponse<String> response = this.bookUsecase.updateBook(body);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping(value = "/delete/{bookId}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BaseResponse<String>> deleteBook(@RequestHeader(value = "ax-request-id", required = false) String requestId,
                                                           @RequestHeader(value = "ax-request-at", required = false) String requestAt,
                                                           @PathVariable(value = "bookId") String bookId,
                                                           HttpServletRequest request) {
        BaseResponse<String> response = this.bookUsecase.deleteBook(bookId);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
