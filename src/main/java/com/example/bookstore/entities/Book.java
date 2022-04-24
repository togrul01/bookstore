package com.example.bookstore.entities;

import com.example.bookstore.entities.dto.AuthorDTO;
import com.example.bookstore.entities.dto.BookDTO;
import com.example.bookstore.util.MyUtils;
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
@Table(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "authors"})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @NotBlank
    @Column(nullable = false, name = "book_name")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(nullable = false)
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @Column(name = "state")
    private int state;

    @Column(name = "page_count")
    private Integer pageCount;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Book() {
    }

    public Book(Integer bookId, String bookName, Publisher publisher, List<Author> authors, int state) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.publisher = publisher;
        this.authors = authors;
        this.state = state;
    }

    public Book(BookDTO bookDTO) {
        this.bookId = bookDTO.getBookId();
        this.bookName = bookDTO.getBookName();
        this.state = bookDTO.getState();
        this.publisher = new Publisher(bookDTO.getPublisherDTO());
        this.authors = MyUtils.getAuthors(bookDTO.getAuthorDTOS());
        this.pageCount = bookDTO.getPageCount();
        this.genre = new Genre(bookDTO.getGenreDTO());
    }

}
