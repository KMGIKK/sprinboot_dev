package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:04 AM
 * @since : 2/21/2024
 **/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }

}
