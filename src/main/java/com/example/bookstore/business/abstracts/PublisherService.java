package com.example.bookstore.business.abstracts;

import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.entities.dto.PublisherDTO;

import java.util.List;

public interface PublisherService {

    Result addPublisher(PublisherDTO publisherDTO);

    Result updatePublisher(PublisherDTO publisherDTO);

    Result removePublisher(Integer publisherId);

    DataResult<List<Publisher>> getAllPage(int pageNo, int pageSize);

    DataResult<List<Publisher>> getAllSorted();

    DataResult<Publisher> getAllByPublisherIdAndState(Integer publisherId);

    DataResult<List<Publisher>> getAllByPublisherNameStartingWithAndState(String publisherName);

    DataResult<List<Publisher>> getByPublisherNameContainsAndState(String publisherName);

    DataResult<List<Publisher>> findAllByState();

}
