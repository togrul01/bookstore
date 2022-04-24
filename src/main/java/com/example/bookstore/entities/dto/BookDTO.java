package com.example.bookstore.entities.dto;

import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookDTO {
    private Integer bookId;
    private String bookName;
    private int state;
    private PublisherDTO publisherDTO;
    private List<AuthorDTO> authorDTOS = new ArrayList<>();
    private Integer pageCount;
    private GenreDTO genreDTO;

    public BookDTO() {
    }

    public BookDTO(Book book) {
        this.bookId = book.getBookId();
        this.bookName = book.getBookName();
        this.publisherDTO = new PublisherDTO(book.getPublisher());
        this.authorDTOS = getAuthors(book.getAuthors());
        this.pageCount = book.getPageCount();
        this.genreDTO = new GenreDTO(book.getGenre());
    }

    public List<AuthorDTO> getAuthors(List<Author> authors) {
        List<AuthorDTO> authorDTOS = new ArrayList<>();
        for (Author author : authors) {
            authorDTOS.add(new AuthorDTO(author));
        }
        return authorDTOS;
    }
}
