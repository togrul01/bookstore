package com.example.bookstore.database;

import com.example.bookstore.entities.BookAuthor;
import com.example.bookstore.entities.dto.BookAuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {

    @Query("SELECT NEW com.example.bookstore.entities.dto.BookAuthorDTO(a.authorName, a.authorSurname, b.bookName, g.genreName, p.publisherName) " +
            " from BookAuthor ba left join Book b on ba.bookId = b.bookId" +
            " left join Author a on ba.authorId = a.authorId" +
            " left join Genre g on b.genre.genreId = g.genreId" +
            " left join Publisher p on b.publisher.publisherId = p.publisherId where a.state = 0 and g.state = 0 and p.state = 0 and b.state = 0")
    List<BookAuthorDTO> gerAllBookDetails();

}
