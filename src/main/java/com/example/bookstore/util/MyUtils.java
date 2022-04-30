package com.example.bookstore.util;

import com.example.bookstore.database.AuthorRepository;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.dto.AuthorDTO;

import java.util.ArrayList;
import java.util.List;

public class MyUtils {

    public static List<Author> getAuthors(List<AuthorDTO> authorDTOS) {
        List<Author> authors = new ArrayList<>();
        for (AuthorDTO authorDTO : authorDTOS) {
            authors.add(new Author(authorDTO));
        }
        return authors;

    }
}
