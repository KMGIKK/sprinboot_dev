package com.example.demo.advisor;

import com.example.demo.exception.NotFoundException;
import com.example.demo.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : K.M.G.I.K.konara
 * @Time :11:13 AM
 * @since : 2/21/2024
 **/
@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handlerNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Error Comming",e.getMessage()), HttpStatus.NOT_FOUND
        );
    }
}
