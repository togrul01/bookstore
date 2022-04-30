package com.example.bookstore.enums;

public enum SuccessCode {
    DATA_LISTED("Data Listed :"),
    SUCCESSFUL("Successful : "),

    SAVED("saved :"),
    DELETED("delete :"),
    UPDATED("update :"),
    ACCESS_DENIED("Access is denied");



    private final String message;

    SuccessCode(String message) {
        this.message = message;
    }

    public String getMessage(String className) {
        return className + " " + message;
    }

    public String getMessage() {
        return message;
    }
}


