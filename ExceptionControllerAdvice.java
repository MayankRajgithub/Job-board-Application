package com.jobboard.Job.Board.Apllicatins.exception;

import com.jobboard.Job.Board.Apllicatins.utility.ErrorInfo;
import org.hibernate.cfg.Environment;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    private Environment environment;
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo>generalException(Exception exception){
        ErrorInfo error = new ErrorInfo(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
   return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(JobPortalException.class)
    public ResponseEntity<ErrorInfo>generalException(JobPortalException exception){
        String msg =environment.getProperties().getProperty(exception.getMessage());
        ErrorInfo error = new ErrorInfo(msg, HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
