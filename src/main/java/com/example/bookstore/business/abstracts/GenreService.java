package com.example.bookstore.business.abstracts;

import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.entities.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    Result addGenre(GenreDTO genreDTO);

    Result updateGenre(GenreDTO genreDTO);

    Result removeGenre(Integer id);

    DataResult<Genre> findByGenreIdAndState(Integer id);

    DataResult<List<Genre>> getAllPage(int pageNo, int pageSize);

    DataResult<List<Genre>> findAllSorted();

    DataResult<List<Genre>> findAllByStateAndGenreNameStartsWith(String genreName);

    DataResult<List<Genre>> findAllByStateAndGenreNameContains(String genreName);

    DataResult<List<Genre>> findAllByState();

}
