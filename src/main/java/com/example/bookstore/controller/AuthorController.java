package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.AuthorService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.dto.AuthorDTO;
import com.example.bookstore.enums.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@Tag(name="Author services",description = "Author controller")
public class AuthorController {

    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @Operation(summary = "You are adding this Author")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Successfully add Author")})
    public Result addAuthor(@RequestBody AuthorDTO authorDTO) {
        return service.addAuthor(authorDTO);
    }

    @PostMapping("/update")
    @Operation(summary = "You are update this Author")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully update Author")})
    public Result updateAuthor(@RequestBody AuthorDTO authorDTO) {
        return service.updateAuthor(authorDTO);
    }

    @PostMapping("/remove")
    @Operation(summary = "You are remove this Author")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully deleted Author")})
    public Result removeAuthor(@RequestParam Integer authorId) {
        return service.removeAuthor(authorId);
    }

    @GetMapping("/getAllSorted")
    @Operation(summary = "You are sort this Author")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Successfully sort Author")})
    public DataResult<List<Author>> getAllSorted() {
        return service.getAllSorted();
    }

    @GetMapping("/getAllPage")
    @Operation(summary = "You are getAllPage this Author")
    @ApiResponses(value = {@ApiResponse(responseCode = "205", description = "Successfully getAllPage Author")})
    public DataResult<List<Author>> getAllPage(int pageNo, int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getById")
    @Operation(summary = "This gets author by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "206", description = "Successfully getById Author")})
    public DataResult<Author> findByAuthorIdAndState(@RequestParam Integer authorId) {
        return service.findByAuthorIdAndState(authorId);
    }

    @GetMapping("/getByStartName")
    @Operation(summary = "This gets author by name")
    @ApiResponses(value = {@ApiResponse(responseCode = "207", description = "Successfully getByStartName Author")})
    public DataResult<List<Author>> findAllByAuthorNameStartingWithAndState(@RequestParam String authorName) {
        return service.findAllByAuthorNameStartingWithAndState(authorName);
    }

    @GetMapping("/getByStartSurName")
    @Operation(summary = "This gets author by surName")
    @ApiResponses(value = {@ApiResponse(responseCode = "208", description = "Successfully getByStartSurName Author")})
    public DataResult<List<Author>> findAllByAuthorSurnameStartingWithAndState(@RequestParam String authorSurname) {
        return service.findAllByAuthorSurnameStartingWithAndState(authorSurname);
    }

    @GetMapping("/findAllByState")
    public DataResult<List<Author>> findAllByState() {
        return service.findAllByState();
    }

}
