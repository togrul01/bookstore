package com.example.bookstore.business.abstracts;

import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.dto.BookDTO;

import java.util.List;

public interface BookService {

    Result addBook(BookDTO bookDTO);

    Result updateBook(BookDTO bookDTO);

    Result removeBook(Integer bookId);

    DataResult<List<Book>> getAllPage(int pageNo,int pageSize);

    DataResult<List<Book>> getAllSorted();

    DataResult<Book> findByBookIdAndState(Integer bookId);

    DataResult<List<Book>> getByBookNameStartsWith(String bookName);

    DataResult<List<Book>> findAllByStateAndPublisher_PublisherId(Integer publisherId);

    DataResult<List<Book>> findAllByStateAndPublisher_PublisherName(String publisherName);

    DataResult<List<Book>> findAllByState();

}
