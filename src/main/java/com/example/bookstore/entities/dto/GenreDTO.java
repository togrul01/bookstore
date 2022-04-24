package com.example.bookstore.entities.dto;

import com.example.bookstore.entities.Genre;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {
    private Integer genreId;
    private String genreName;
    private int state;

    public GenreDTO() {
    }

    public GenreDTO(Genre genre) {
        this.genreId = genre.getGenreId();
        this.genreName = genre.getGenreName();
        this.state = genre.getState();
    }
}
