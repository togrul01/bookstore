package com.example.bookstore.util;

import com.example.bookstore.database.AuthorRepository;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.dto.AuthorDTO;
import com.example.bookstore.entities.dto.BookDTO;
import com.example.bookstore.entities.dto.GenreDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyUtils {

    public static List<Author> getAuthors(List<AuthorDTO> authorDTOS) {
//        List<Author> authors = new ArrayList<>();
//        for (AuthorDTO authorDTO : authorDTOS) {
//            authors.add(new Author(authorDTO));
//        }
//        return authors;
        return authorDTOS.stream().map(Author::new).collect(Collectors.toList());

    }

    public static List<AuthorDTO> getAuthorDTOS(List<Author> authors) {
//        List<AuthorDTO> authorDTOS = new ArrayList<>();
//        for (Author author : authors) {
//            authorDTOS.add(new AuthorDTO(author));
//        }
//        return authorDTOS;
        return authors.stream().map(AuthorDTO::new).collect(Collectors.toList());
    }

    public static List<BookDTO> getBookDTOS(List<Book> books) {
//        List<BookDTO> bookDTOS = new ArrayList<>();
//        for (Book book : books) {
//            bookDTOS.add(new BookDTO(book));
//        }
//        return bookDTOS;
        return books.stream().map(BookDTO::new).collect(Collectors.toList());
    }

    public static List<GenreDTO> genreDTOS(List<Genre> genres) {
        return genres.stream().map(GenreDTO::new).collect(Collectors.toList());
    }

}
