package com.example.bookstore.database;

import com.example.bookstore.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    Genre findByGenreIdAndState(Integer id, int state);

    List<Genre> findAllByStateOrderByGenreName(int state);

    List<Genre> findAllByGenreNameStartsWithAndState(@Param("genreName") String genreName, int state);

    List<Genre> findAllByGenreNameContainsAndState(@Param("genreName") String genreName, int state);

    List<Genre> findAllByState(int state);

}
