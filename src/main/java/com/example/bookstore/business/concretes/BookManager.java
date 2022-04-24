package com.example.bookstore.business.concretes;

import com.example.bookstore.business.abstracts.BookService;
import com.example.bookstore.core.*;
import com.example.bookstore.database.BookRepository;
import com.example.bookstore.entities.Book;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.entities.dto.BookDTO;
import com.example.bookstore.enums.SuccessCode;
import com.example.bookstore.util.MyUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookManager implements BookService {

    private final BookRepository repository;

    public BookManager(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result addBook(BookDTO bookDTO) {
        try {
            Book book = new Book(bookDTO);
            repository.save(book);
            return new SuccessDataResult<>(book,
                    SuccessCode.SAVED.getMessage("Book"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result updateBook(BookDTO bookDTO) {
        try {
            Book book = repository.findByBookIdAndState(bookDTO.getBookId(), 0);
            book.setBookName(bookDTO.getBookName());
            book.setPublisher(new Publisher(bookDTO.getPublisherDTO()));
            book.setAuthors(MyUtils.getAuthors(bookDTO.getAuthorDTOS()));
            book.setPageCount(bookDTO.getPageCount());
            book.setGenre(new Genre(bookDTO.getGenreDTO()));
            return new SuccessDataResult<>(repository.save(book),
                    SuccessCode.UPDATED.getMessage("Book"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result removeBook(Integer bookId) {
        try {
            Book book = repository.findByBookIdAndState(bookId, 0);
            book.setState(1);
            repository.save(book);
            return new SuccessResult(SuccessCode.DELETED.getMessage("Book"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Book>> getAllPage(int pageNo, int pageSize) {
        try {
            Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
            List<Book> books = repository.findAll(pageable).getContent();
            return new SuccessDataResult<>(getPageableBook(books), SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Book>> getAllSorted() {
        try {
            return new SuccessDataResult<>(repository.findAllByStateOrderByBookName(0),
                    SuccessCode.SUCCESSFUL.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<Book> findByBookIdAndState(Integer bookId) {
        try {
            return new SuccessDataResult<>(repository.
                    findByBookIdAndState(bookId, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorDataResult<>(ex.getMessage());
        }
    }

    @Override
    public DataResult<List<Book>> getByBookNameStartsWith(String bookName) {
        try {
            return new SuccessDataResult<>(repository.
                    getByBookNameStartsWithAndState(bookName, 0), SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Book>> findAllByStateAndPublisher_PublisherId(Integer publisherId) {
        try {
            return new SuccessDataResult<>(repository.
                    findAllByStateAndPublisher_PublisherIdAndPublisher_State(0, publisherId, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Book>> findAllByStateAndPublisher_PublisherName(String publisherName) {
        try {
            return new SuccessDataResult<>(repository.
                    findAllByStateAndPublisher_PublisherNameAndPublisher_State(0, publisherName, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Book>> findAllByState() {
        try {
            return new SuccessDataResult<>(repository.findAllByState(0), SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    private List<Book> getPageableBook(List<Book> bookList) {
        List<Book> books = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getState() == 0) {
                books.add(book);
            }
        }
        return books;
    }
}
