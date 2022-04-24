package com.example.bookstore.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "book_author")
public class BookAuthor implements Serializable{

    private static final long serialVersionUID = 19L;

    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "author_id")
    private Integer authorId;

    public BookAuthor() {
    }
}
