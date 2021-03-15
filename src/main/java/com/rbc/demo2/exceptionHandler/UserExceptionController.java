package com.rbc.demo2.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(value = UserNotFoundException.class)
   public ResponseEntity<Object> exception(UserNotFoundException exception) {
      return new ResponseEntity<>("Enter valid user-id", HttpStatus.NOT_FOUND);
   }
}
