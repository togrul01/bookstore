package com.example.bookstore.database;

import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    List<Publisher> getAllByStateOrderByPublisherName(int state);

    Publisher getAllByPublisherIdAndState(Integer publisherId, int state);

    List<Publisher> getAllByPublisherNameStartingWithAndState(@Param("publisherName") String publisherName, int state);

    List<Publisher> getByPublisherNameContainsAndState(@Param("publisherName") String publisherName, int state);

    List<Publisher> findAllByState(int state);

}
