package com.example.bookstore.core;


import com.example.bookstore.enums.SuccessCode;

public class SuccessDataResult<T> extends DataResult<T> {
    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }
    public SuccessDataResult(T data, SuccessCode successCode) {
        super(data, true, successCode.getMessage());
    }

    public SuccessDataResult(T data, boolean success) {
        super(data, success);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(String message) {
        super(null, true, message);
    }

}
