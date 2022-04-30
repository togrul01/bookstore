package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.BookService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Tag(name="Book services",description = "Book controller")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @Operation(summary = "You are adding this Book")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully add Book")})
    public Result addBook(@RequestBody BookDTO bookDTO) {
        return service.addBook(bookDTO);
    }

    @PostMapping("/update")
    @Operation(summary = "You are update this Book")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully update Book")})
    public Result updateBook(@RequestBody BookDTO bookDTO) {
        return service.updateBook(bookDTO);
    }

    @PostMapping("/remove")
    @Operation(summary = "You are remove this Book")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Successfully remove Book")})
    public Result removeBook(@RequestParam Integer bookId) {
        return service.removeBook(bookId);
    }

    @GetMapping("/getAllPage")
    @Operation(summary = "You are getAllPage this Book")
    @ApiResponses(value = {@ApiResponse(responseCode = "203", description = "Successfully getAllPage Book")})
    public DataResult<List<Book>> getAllPage(int pageNo, int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getAllSorted")
    @Operation(summary = "You are sort this Book")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Successfully sort Book")})
    public DataResult<List<Book>> getAllSorted() {
        return service.getAllSorted();
    }

    @GetMapping("/getById")
    @Operation(summary = "This gets Book by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "205", description = "Successfully getById Book")})
    public DataResult<Book> getAllById(@RequestParam Integer bookId) {
        return service.findByBookIdAndState(bookId);
    }

    @GetMapping("/getByBookNameStartsWith")
    @Operation(summary = "This gets Book by name")
    @ApiResponses(value = {@ApiResponse(responseCode = "206", description = "Successfully getByStartName Book")})
    public DataResult<List<Book>> getByBookNameStartsWith(@RequestParam String bookName) {
        return service.getByBookNameStartsWith(bookName);
    }

    @GetMapping("/findAllByStateAndPublisher_PublisherId")
    @Operation(summary = "This gets Book by PublisherId")
    @ApiResponses(value = {@ApiResponse(responseCode = "206", description = "Successfully PublisherId Book")})
    public DataResult<List<Book>> findAllByStateAndPublisher_PublisherId(@RequestParam Integer publisherId) {
        return service.findAllByStateAndPublisher_PublisherId(publisherId);
    }

    @GetMapping("/findAllByStateAndPublisher_PublisherName")
    @Operation(summary = "This gets Book by PublisherName")
    @ApiResponses(value = {@ApiResponse(responseCode = "207", description = "Successfully PublisherName Book")})
    public DataResult<List<Book>> findAllByStateAndPublisher_PublisherName(@RequestParam String publisherName) {
        return service.findAllByStateAndPublisher_PublisherName(publisherName);
    }

    @GetMapping("/findAllByState")
    public DataResult<List<Book>> findAllByState() {
        return service.findAllByState();
    }
}
