package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.PublisherService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.entities.dto.PublisherDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Result addPublisher(@RequestBody PublisherDTO publisherDTO) {
        return service.addPublisher(publisherDTO);
    }

    @PostMapping("/update")
    public Result updatePublisher(@RequestBody PublisherDTO publisherDTO) {
        return service.updatePublisher(publisherDTO);
    }

    @PostMapping("/remove")
    public Result removePublisher(@RequestParam Integer publisherId) {
        return service.removePublisher(publisherId);
    }

    @GetMapping("/getAllPage")
    public DataResult<List<Publisher>> getAllPage(int pageNo, int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Publisher>> getAllSorted() {
        return service.getAllSorted();
    }

    @GetMapping("/getById")
    public DataResult<Publisher> getAllByPublisherIdAndState(@RequestParam Integer publisherId) {
        return service.getAllByPublisherIdAndState(publisherId);
    }

    @GetMapping("/getAllStartWith")
    public DataResult<List<Publisher>> getAllByPublisherNameStartingWithAndState(@RequestParam String publisherName) {
        return service.getAllByPublisherNameStartingWithAndState(publisherName);
    }

    @GetMapping("/getByContains")
    public DataResult<List<Publisher>> getByPublisherNameContainsAndState(@RequestParam String publisherName) {
        return service.getByPublisherNameContainsAndState(publisherName);
    }

    @GetMapping("/findAllByState")
    public DataResult<List<Publisher>> findAllByState(){
        return service.findAllByState();
    }
}
