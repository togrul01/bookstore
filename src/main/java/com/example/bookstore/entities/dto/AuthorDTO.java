package com.example.bookstore.entities.dto;

import com.example.bookstore.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDTO {
    private Integer authorId;
    private String authorName;
    private String authorSurname;
    private int state;

    public AuthorDTO() {
    }

    public AuthorDTO(Author author) {
        this.authorId = author.getAuthorId();
        this.state = author.getState();
        this.authorSurname = author.getAuthorSurname();
        this.authorName = author.getAuthorName();
    }
}
