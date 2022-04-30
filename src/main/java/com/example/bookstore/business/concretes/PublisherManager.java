package com.example.bookstore.business.concretes;

import com.example.bookstore.business.abstracts.PublisherService;
import com.example.bookstore.core.DataResult;
import com.example.bookstore.core.ErrorDataResult;
import com.example.bookstore.core.Result;
import com.example.bookstore.core.SuccessDataResult;
import com.example.bookstore.database.PublisherRepository;
import com.example.bookstore.entities.Genre;
import com.example.bookstore.entities.Publisher;
import com.example.bookstore.entities.dto.PublisherDTO;
import com.example.bookstore.enums.SuccessCode;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherManager implements PublisherService {

    private final PublisherRepository repository;

    public PublisherManager(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result addPublisher(PublisherDTO publisherDTO) {
        try {
            Publisher publisher = new Publisher(publisherDTO);
            return new SuccessDataResult<>(repository.save(publisher),
                    SuccessCode.SAVED.getMessage("Publisher"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }

    }

    @Override
    public Result updatePublisher(PublisherDTO publisherDTO) {
        try {
            Publisher publisher = repository.getAllByPublisherIdAndState(publisherDTO.getPublisherId(), 0);
            publisher.setPublisherName(publisherDTO.getPublisherName());
            return new SuccessDataResult<>(repository.save(publisher),
                    SuccessCode.UPDATED.getMessage("Publisher"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public Result removePublisher(Integer publisherId) {
        try {
            Publisher publisher = repository.getAllByPublisherIdAndState(publisherId, 0);
            publisher.setState(-1);
            return new SuccessDataResult<>(repository.save(publisher),
                    SuccessCode.DELETED.getMessage("Publisher"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Publisher>> getAllPage(int pageNo, int pageSize) {
        try {
            Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
            List<Publisher> publishers = repository.findAll(pageable).getContent();
            return new SuccessDataResult<>(getPageablePublisher(publishers),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Publisher>> getAllSorted() {
        try {
            return new SuccessDataResult<>(repository.getAllByStateOrderByPublisherName(0),
                    SuccessCode.SUCCESSFUL.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<Publisher> getAllByPublisherIdAndState(Integer publisherId) {
        try {
            return new SuccessDataResult<>(repository.
                    getAllByPublisherIdAndState(publisherId, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Publisher>> getAllByPublisherNameStartingWithAndState(String publisherName) {
        try {
            return new SuccessDataResult<>(repository.
                    getAllByPublisherNameStartingWithAndState(publisherName, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Publisher>> getByPublisherNameContainsAndState(String publisherName) {
        try {
            return new SuccessDataResult<>(repository.
                    getByPublisherNameContainsAndState(publisherName, 0),
                    SuccessCode.DATA_LISTED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    @Override
    public DataResult<List<Publisher>> findAllByState() {
        try {
            return new SuccessDataResult<>(repository.findAllByState(0));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorDataResult<>(e.getMessage());
        }
    }

    private List<Publisher> getPageablePublisher(List<Publisher> publisherList) {
        List<Publisher> publishers = new ArrayList<>();

        for (Publisher publisher : publisherList) {
            if (publisher.getState() == 0) {
                publishers.add(publisher);
            }
        }
        return publishers;
    }

}
