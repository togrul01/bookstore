package com.example.bookstore.entities;

import com.example.bookstore.entities.dto.AuthorDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "author")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "books"})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @NotBlank
    @Column(nullable = false, name = "author_name")
    private String authorName;

    @NotBlank
    @Column(nullable = false, name = "author_surname")
    private String authorSurname;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    @Column(name = "state")
    private int state;

    public Author() {
    }

    public Author(Integer authorId, String authorName, String authorSurname, List<Book> books, int state) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.books = books;
        this.state = state;
    }

    public Author(AuthorDTO authorDTO) {
        this.authorId = authorDTO.getAuthorId();
        this.authorName = authorDTO.getAuthorName();
        this.authorSurname = authorDTO.getAuthorSurname();
        this.state = authorDTO.getState();
    }
}
