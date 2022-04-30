package com.example.bookstore.database;

import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.dto.AuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllByStateOrderByAuthorName(int state);

    Author findByAuthorIdAndState(Integer authorId, int state);

    List<Author> findAllByAuthorNameStartingWithAndState(@Param("authorName") String authorName, int state);

    List<Author> findAllByAuthorSurnameStartingWithAndState(@Param("authorSurname") String authorSurname, int state);

    List<Author> findAllByState(int state);
}
