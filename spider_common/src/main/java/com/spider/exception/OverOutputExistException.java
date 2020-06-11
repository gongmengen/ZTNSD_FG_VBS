package com.spider.exception;

public class OverOutputExistException extends Exception {

    private String message;

    public OverOutputExistException(String msg)
    {
        this.message = msg;
    }
    public String getMessage() {
        return message;
    }

}
