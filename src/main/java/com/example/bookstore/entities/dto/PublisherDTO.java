package com.example.bookstore.entities.dto;

import com.example.bookstore.entities.Publisher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublisherDTO {
    private Integer publisherId;
    private String publisherName;
    private int state;

    public PublisherDTO() {
    }

    public PublisherDTO(Publisher publisher) {
        this.publisherId = publisher.getPublisherId();
        this.publisherName = publisher.getPublisherName();
        this.state = publisher.getState();
    }
}
