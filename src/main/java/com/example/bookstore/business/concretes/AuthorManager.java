package com.example.bookstore.business.concretes;

import com.example.bookstore.business.abstracts.AuthorService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.ErrorDataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.core.SuccessDataResult;
import com.example.bookstore.database.AuthorRepository;
import com.example.bookstore.entities.Author;
import com.example.bookstore.entities.dto.AuthorDTO;
import com.example.bookstore.enums.SuccessCode;
import com.example.bookstore.util.MyUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorManager implements AuthorService {

    private final AuthorRepository repository;

    public AuthorManager(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result addAuthor(AuthorDTO authorDTO) {
        try {
            Author author = new Author(authorDTO);
            return new SuccessDataResult<>(repository.save(author),
                    SuccessCode.SAVED.getMessage("Author"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result updateAuthor(AuthorDTO authorDTO) {
        try {
            Author author = repository.findByAuthorIdAndState(authorDTO.getAuthorId(), 0);
            author.setAuthorName(authorDTO.getAuthorName());
            author.setAuthorSurname(authorDTO.getAuthorSurname());
            return new SuccessDataResult<>(repository.save(author),
                    SuccessCode.UPDATED.getMessage("Author"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result removeAuthor(Integer authorID) {
        try {
            Author author = repository.findByAuthorIdAndState(authorID, 0);
            author.setState(1);
            return new SuccessDataResult<>(repository.save(author),
                    SuccessCode.DELETED.getMessage("Author"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<AuthorDTO>> getAllSorted() {
        try {
            List<AuthorDTO> authorDTOS = MyUtils.getAuthorDTOS(repository.findAllByStateOrderByAuthorName(0));
            return new SuccessDataResult<>(authorDTOS,
                    SuccessCode.SUCCESSFUL.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Author>> getAllPage(int pageNo, int pageSize) {
        try {
            Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
            List<Author> authors = repository.findAll(pageable).getContent();
            return new SuccessDataResult<>(getPageableAuthor(authors), SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<Author> findByAuthorIdAndState(Integer authorId) {
        try {

            return new SuccessDataResult<>(repository.findByAuthorIdAndState(authorId, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<AuthorDTO>> findAllByAuthorNameStartingWithAndState(String authorName) {
        try {
            List<AuthorDTO> authorDTOS = MyUtils.getAuthorDTOS(repository.findAllByAuthorNameStartingWithAndState(authorName, 0));
            return new SuccessDataResult<>(authorDTOS,
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<AuthorDTO>> findAllByAuthorSurnameStartingWithAndState(String authorSurname) {
        try {
            List<AuthorDTO> authorDTOS = MyUtils.getAuthorDTOS(repository.
                    findAllByAuthorSurnameStartingWithAndState(authorSurname, 0));
            return new SuccessDataResult<>(authorDTOS,
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<AuthorDTO>> findAllByState() {
        try {
            List<AuthorDTO> authorDTOS = MyUtils.getAuthorDTOS(repository.findAllByState(0));
            return new SuccessDataResult<>(authorDTOS, SuccessCode.DATA_LISTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    private List<Author> getPageableAuthor(List<Author> authorList) {
        List<Author> authors = new ArrayList<>();

        for (Author author : authorList) {
            if (author.getState() == 0) {
                authors.add(author);
            }
        }
        return authors;
    }
}
