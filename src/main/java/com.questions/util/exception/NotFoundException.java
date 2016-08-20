package com.questions.util.exception;

/**
 * Created by T on 20.08.2016.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg)
    {
        super(msg);
    }
}
