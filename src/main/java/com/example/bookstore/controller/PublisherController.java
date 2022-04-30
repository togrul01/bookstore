package com.example.bookstore.controller;

import com.example.bookstore.business.abstracts.PublisherService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.entities.dto.PublisherDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
@Tag(name = "Publisher services", description = "Publisher controller")
public class PublisherController {

    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @PostMapping("/add")
    @Operation(summary = "You are adding this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully add Publisher")})
    public Result addPublisher(@RequestBody PublisherDTO publisherDTO) {
        return service.addPublisher(publisherDTO);
    }

    @PostMapping("/update")
    @Operation(summary = "You are update this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully update Publisher")})
    public Result updatePublisher(@RequestBody PublisherDTO publisherDTO) {
        return service.updatePublisher(publisherDTO);
    }

    @PostMapping("/remove")
    @Operation(summary = "You are remove this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "202", description = "Successfully remove Publisher")})
    public Result removePublisher(@RequestParam Integer publisherId) {
        return service.removePublisher(publisherId);
    }

    @GetMapping("/getAllPage")
    @Operation(summary = "You are getAllPage this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "203", description = "Successfully getAllPage Publisher")})
    public DataResult<List<Publisher>> getAllPage(int pageNo, int pageSize) {
        return service.getAllPage(pageNo, pageSize);
    }

    @GetMapping("/getAllSorted")
    @Operation(summary = "You are getAllSorted this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Successfully getAllSorted Publisher")})
    public DataResult<List<Publisher>> getAllSorted() {
        return service.getAllSorted();
    }

    @GetMapping("/getById")
    @Operation(summary = "You are getById this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "205", description = "Successfully getById Publisher")})
    public DataResult<Publisher> getAllByPublisherIdAndState(@RequestParam Integer publisherId) {
        return service.getAllByPublisherIdAndState(publisherId);
    }

    @GetMapping("/getAllStartWith")
    @Operation(summary = "You are getAllStartWith this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "206", description = "Successfully getAllStartWith Publisher")})
    public DataResult<List<Publisher>> getAllByPublisherNameStartingWithAndState(@RequestParam String publisherName) {
        return service.getAllByPublisherNameStartingWithAndState(publisherName);
    }

    @GetMapping("/getByContains")
    @Operation(summary = "You are getByContains this Publisher")
    @ApiResponses(value = {@ApiResponse(responseCode = "207", description = "Successfully getByContains Publisher")})
    public DataResult<List<Publisher>> getByPublisherNameContainsAndState(@RequestParam String publisherName) {
        return service.getByPublisherNameContainsAndState(publisherName);
    }

    @GetMapping("/findAllByState")
    public DataResult<List<Publisher>> findAllByState() {
        return service.findAllByState();
    }
}
