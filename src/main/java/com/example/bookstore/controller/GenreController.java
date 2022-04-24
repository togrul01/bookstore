package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.GenreService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.dto.GenreDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genre")
public class GenreController {

    private final GenreService service;

    public GenreController(GenreService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Result addGenre(@RequestBody GenreDTO genreDTO) {
        return service.addGenre(genreDTO);
    }

    @PostMapping("/update")
    public Result updateGenre(@RequestBody GenreDTO genreDTO) {
        return service.updateGenre(genreDTO);
    }

    @PostMapping("/remove")
    public Result removeGenre(@RequestParam Integer id) {
        return service.removeGenre(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Genre>> getAll() {
        return service.findAllByState();
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Genre>> getAllSorted() {
        return service.findAllSorted();
    }

    @GetMapping("findById")
    public DataResult<Genre> getById(@RequestParam Integer id) {
        return service.findByGenreIdAndState(id);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Genre>> getAllByPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getAllByPrefix")
    public DataResult<List<Genre>> getAllByPrefix(@RequestParam String genreName) {
        return service.findAllByStateAndGenreNameStartsWith(genreName);
    }

    @GetMapping("/getAllByContains")
    public DataResult<List<Genre>> getAllByContains(@RequestParam String genreName) {
        return service.findAllByStateAndGenreNameContains(genreName);
    }

}
