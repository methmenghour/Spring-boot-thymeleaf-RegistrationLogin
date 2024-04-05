package com.menghour.registrationlogin.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiException(ApiException e){
		// list all error Exception
		return ResponseEntity
				.status(e.getStatus())
				.body(e.getMessage());

	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException e) {
	   String message = e.getBindingResult()
                         .getFieldErrors()
                         .stream()
                         .map(FieldError::getDefaultMessage)
                         .collect(Collectors.toSet())
                         .toString()
                         .replaceAll("\\[*]*", "");
	   
	    return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(message);

    }
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> jsonFormatPattern(HttpMessageNotReadableException e) {

	   String message = "Error LocalDateTime Pattern";            
	    return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(message);
    }
}
