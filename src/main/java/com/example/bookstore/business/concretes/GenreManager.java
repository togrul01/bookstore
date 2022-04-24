package com.example.bookstore.business.concretes;

import com.example.bookstore.business.abstracts.GenreService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.ErrorDataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.core.SuccessDataResult;
import com.example.bookstore.database.GenreRepository;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.dto.GenreDTO;
import com.example.bookstore.enums.SuccessCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreManager implements GenreService {

    private final GenreRepository repository;

    public GenreManager(GenreRepository repository) {
        this.repository = repository;
    }


    @Override
    public Result addGenre(GenreDTO genreDTO) {
        try {
            Genre genre = new Genre(genreDTO);
            return new SuccessDataResult<>(repository.save(genre), SuccessCode.SAVED.getMessage("Genre"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result updateGenre(GenreDTO genreDTO) {
        try {
            Genre genre = repository.findByGenreIdAndState(genreDTO.getGenreId(), 0);
            genre.setGenreName(genreDTO.getGenreName());
            return new SuccessDataResult<>(repository.save(genre), SuccessCode.UPDATED.getMessage("Genre"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result removeGenre(Integer id) {
        try {
            Genre genre = repository.findByGenreIdAndState(id, 0);
            genre.setState(-1);
            return new SuccessDataResult<>(repository.save(genre), SuccessCode.DELETED.getMessage("Genre"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<Genre> findByGenreIdAndState(Integer id) {
        try {
            return new SuccessDataResult<>(repository.findByGenreIdAndState(id, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Genre>> getAllPage(int pageNo, int pageSize) {
        try {
            Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
            List<Genre> genres = repository.findAll(pageable).getContent();
            return new SuccessDataResult<>(getPageableGenres(genres),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Genre>> findAllSorted() {
        try {
            return new SuccessDataResult<>(repository.findAllByStateOrderByGenreName(0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Genre>> findAllByStateAndGenreNameStartsWith(String genreName) {
        try {
            return new SuccessDataResult<>(repository.findAllByGenreNameStartsWithAndState(genreName, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Genre>> findAllByStateAndGenreNameContains(String genreName) {
        try {
            return new SuccessDataResult<>(repository.findAllByGenreNameContainsAndState(genreName, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Genre>> findAllByState() {
        try {
            return new SuccessDataResult<>(repository.findAllByState(0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    private List<Genre> getPageableGenres(List<Genre> genreList) {
        List<Genre> genres = new ArrayList<>();

        for (Genre genre : genreList) {
            if (genre.getState() == 0) {
                genres.add(genre);
            }
        }
        return genres;
    }
}
