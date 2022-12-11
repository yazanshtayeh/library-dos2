package com.example.front.controller;

import com.example.front.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.Timestamp;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> wrongTypeHandle(MethodArgumentTypeMismatchException ex){
        String message ="the type should be long";
        Long datetime = System.currentTimeMillis();
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setMessage(message);
        exceptionResponse.setTimeStamp(new Timestamp(datetime));
        exceptionResponse.setError("Bad Request");
        exceptionResponse.setType(400);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(noBookWithThisIdExceptuon.class)
    public ResponseEntity<ExceptionResponse> noBody(noBookWithThisIdExceptuon ex){
        String message ="no book with this id";
        Long datetime = System.currentTimeMillis();
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setMessage(message);
        exceptionResponse.setTimeStamp(new Timestamp(datetime));
        exceptionResponse.setError("Bad Request");
        exceptionResponse.setType(400);
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }


}