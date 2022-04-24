package com.example.bookstore.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookAuthorDTO {
    private String authorName;
    private String authorSurname;
    private String bookName;
    private String genreName;
    private String publisherName;
}
