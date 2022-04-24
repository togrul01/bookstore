package com.example.bookstore.business.abstracts;

import com.example.bookstore.core.DataResult;
import com.example.bookstore.entities.dto.BookAuthorDTO;

import java.util.List;

public interface BookAuthorService {

    DataResult<List<BookAuthorDTO>> gerAllBookDetails();

}
