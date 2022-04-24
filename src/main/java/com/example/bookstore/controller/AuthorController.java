package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.AuthorService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.dto.AuthorDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Result addAuthor(@RequestBody AuthorDTO authorDTO) {
        return service.addAuthor(authorDTO);
    }

    @PostMapping("/update")
    public Result updateAuthor(@RequestBody AuthorDTO authorDTO) {
        return service.updateAuthor(authorDTO);
    }

    @PostMapping("/remove")
    public Result removeAuthor(@RequestParam Integer authorId) {
        return service.removeAuthor(authorId);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Author>> getAllSorted() {
        return service.getAllSorted();
    }

    @GetMapping("/getAllPage")
    public DataResult<List<Author>> getAllPage(int pageNo, int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getById")
    public DataResult<Author> findByAuthorIdAndState(@RequestParam Integer authorId) {
        return service.findByAuthorIdAndState(authorId);
    }

    @GetMapping("/getByStartName")
    public DataResult<List<Author>> findAllByAuthorNameStartingWithAndState(@RequestParam String authorName) {
        return service.findAllByAuthorNameStartingWithAndState(authorName);
    }

    @GetMapping("/getByStartSurName")
    public DataResult<List<Author>> findAllByAuthorSurnameStartingWithAndState(@RequestParam String authorSurname) {
        return service.findAllByAuthorSurnameStartingWithAndState(authorSurname);
    }

    @GetMapping("/findAllByState")
    public DataResult<List<Author>> findAllByState() {
        return service.findAllByState();
    }

}
