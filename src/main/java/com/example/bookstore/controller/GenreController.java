package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.GenreService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.dto.GenreDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genre")
@Tag(name="Genre services",description = "Genre controller")
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @Operation(summary = "You are adding this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully add Genre")})
    public Result addGenre(@RequestBody GenreDTO genreDTO) {
        return service.addGenre(genreDTO);
    }

    @PostMapping("/update")
    @Operation(summary = "You are update this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully update Genre")})
    public Result updateGenre(@RequestBody GenreDTO genreDTO) {
        return service.updateGenre(genreDTO);
    }

    @PostMapping("/remove")
    @Operation(summary = "You are remove this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Successfully remove Genre")})
    public Result removeGenre(@RequestParam Integer id) {
        return service.removeGenre(id);
    }

    @GetMapping("/getAll")
    @Operation(summary = "You are getAll this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "203", description = "Successfully getAll Genre")})
    public DataResult<List<Genre>> getAll() {
        return service.findAllByState();
    }

    @GetMapping("/getAllSorted")
    @Operation(summary = "You are sort this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Successfully sort Genre")})
    public DataResult<List<Genre>> getAllSorted() {
        return service.findAllSorted();
    }

    @GetMapping("findById")
    @Operation(summary = "You are findById this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "205", description = "Successfully findById Genre")})
    public DataResult<Genre> getById(@RequestParam Integer id) {
        return service.findByGenreIdAndState(id);
    }

    @GetMapping("/getAllByPage")
    @Operation(summary = "You are getAllPage this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "206", description = "Successfully getAllPage Genre")})
    public DataResult<List<Genre>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getAllByPrefix")
    @Operation(summary = "You are getAllByPrefix this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "207", description = "Successfully getAllByPrefix Genre")})
    public DataResult<List<Genre>> getAllByPrefix(@RequestParam String genreName) {
        return service.findAllByStateAndGenreNameStartsWith(genreName);
    }

    @GetMapping("/getAllByContains")
    @Operation(summary = "You are getAllByContains this Genre")
    @ApiResponses(value = {@ApiResponse(responseCode = "208", description = "Successfully getAllByContains Genre")})
    public DataResult<List<Genre>> getAllByContains(@RequestParam String genreName) {
        return service.findAllByStateAndGenreNameContains(genreName);
    }

}
