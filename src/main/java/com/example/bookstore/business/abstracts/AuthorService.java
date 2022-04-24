package com.example.bookstore.business.abstracts;

import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Result addAuthor(AuthorDTO authorDTO);

    Result updateAuthor(AuthorDTO authorDTO);

    Result removeAuthor(Integer authorID);

    DataResult<List<Author>> getAllSorted();

    DataResult<List<Author>> getAllPage(int pageNo, int pageSize);

    DataResult<Author> findByAuthorIdAndState(Integer authorId);

    DataResult<List<Author>> findAllByAuthorNameStartingWithAndState(String authorName);

    DataResult<List<Author>> findAllByAuthorSurnameStartingWithAndState(String authorSurname);

    DataResult<List<Author>> findAllByState();

}
