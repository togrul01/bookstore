package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.BookAuthorService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.entities.BookAuthor;
import com.example.bookstore.entities.dto.BookAuthorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookAuthorController {

    private final BookAuthorService service;

    public BookAuthorController(BookAuthorService service) {
        this.service = service;
    }

    @GetMapping("/")
    public DataResult<List<BookAuthorDTO>> getAllBook() {
        return service.gerAllBookDetails();
    }
}
