package com.example.bookstore.business.concretes;

import com.example.bookstore.business.abstracts.BookAuthorService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.ErrorDataResult;
import com.example.bookstore.core.SuccessDataResult;
import com.example.bookstore.database.BookAuthorRepository;
import com.example.bookstore.entities.dto.BookAuthorDTO;
import com.example.bookstore.enums.SuccessCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorManager implements BookAuthorService {

    private final BookAuthorRepository repository;

    public BookAuthorManager(BookAuthorRepository repository) {
        this.repository = repository;
    }


    @Override
    public DataResult<List<BookAuthorDTO>> gerAllBookDetails() {
        try {
            return new SuccessDataResult<>(repository.gerAllBookDetails(), SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }
}
