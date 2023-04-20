package com.example.springdoctestproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFound extends RuntimeException{
    public ItemNotFound(String item, String id) {
        super(item + " with id " + id + " not found");
    }
}
