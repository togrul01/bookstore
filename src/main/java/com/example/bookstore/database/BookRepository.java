package com.example.bookstore.database;

import com.example.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByStateOrderByBookName(int state);

    Book findByBookIdAndState(Integer bookId, int state);

    List<Book> getByBookNameStartsWithAndState(@Param("bookName") String bookName, int state);

    List<Book> findAllByStateAndPublisher_PublisherIdAndPublisher_State(int state, Integer publisherId, int publisherState);

    List<Book> findAllByStateAndPublisher_PublisherNameAndPublisher_State(int state, String publisherName, int publisherState);

    List<Book> findAllByState(int state);


}
