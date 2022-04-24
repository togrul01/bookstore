package com.example.bookstore.entities;

import com.example.bookstore.entities.dto.PublisherDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "publisher")
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;

    @NotBlank
    @Column(nullable = false, name = "publisher_name")
    private String publisherName;

    @Column(name = "state")
    private int state;

    public Publisher() {
    }

    public Publisher(Integer publisherId, String publisherName, int state) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.state = state;
    }

    public Publisher(PublisherDTO publisherDTO) {
        this.publisherId = publisherDTO.getPublisherId();
        this.publisherName = publisherDTO.getPublisherName();
        this.state = publisherDTO.getState();
    }
}
