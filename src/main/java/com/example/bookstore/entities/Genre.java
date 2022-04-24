package com.example.bookstore.entities;

import com.example.bookstore.entities.dto.GenreDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "genre")
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    @Column(name = "genre_name")
    private String genreName;

    private int state;

    public Genre() {
    }

    public Genre(Integer genreId, String genreName, int state) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.state = state;
    }

    public Genre(GenreDTO genreDTO) {
        this.genreId = genreDTO.getGenreId();
        this.genreName = genreDTO.getGenreName();
        this.state = genreDTO.getState();
    }

}
