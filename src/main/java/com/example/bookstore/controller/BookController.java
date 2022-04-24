package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.BookService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.dto.BookDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Result addBook(@RequestBody BookDTO bookDTO) {
        return service.addBook(bookDTO);
    }

    @PostMapping("/update")
    public Result updateBook(@RequestBody BookDTO bookDTO) {
        return service.updateBook(bookDTO);
    }

    @PostMapping("/remove")
    public Result removeBook(@RequestParam Integer bookId) {
        return service.removeBook(bookId);
    }

    @GetMapping("/getAllPage")
    public DataResult<List<Book>> getAllPage(int pageNo, int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Book>> getAllSorted() {
        return service.getAllSorted();
    }

    @GetMapping("/getById")
    public DataResult<Book> getAllById(@RequestParam Integer bookId) {
        return service.findByBookIdAndState(bookId);
    }

    @GetMapping("/getByBookNameStartsWith")
    public DataResult<List<Book>> getByBookNameStartsWith(@RequestParam String bookName) {
        return service.getByBookNameStartsWith(bookName);
    }

    @GetMapping("/findAllByStateAndPublisher_PublisherId")
    public DataResult<List<Book>> findAllByStateAndPublisher_PublisherId(@RequestParam Integer publisherId) {
        return service.findAllByStateAndPublisher_PublisherId(publisherId);
    }

    @GetMapping("/findAllByStateAndPublisher_PublisherName")
    public DataResult<List<Book>> findAllByStateAndPublisher_PublisherName(@RequestParam String publisherName) {
        return service.findAllByStateAndPublisher_PublisherName(publisherName);
    }

    @GetMapping("/findAllByState")
    public DataResult<List<Book>> findAllByState() {
        return service.findAllByState();
    }
}
