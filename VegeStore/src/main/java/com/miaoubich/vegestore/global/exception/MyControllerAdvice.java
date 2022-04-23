package com.miaoubich.vegestore.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.miaoubich.vegestore.custom.exception.EmptyFieldsException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyFieldsException.class)
	public ResponseEntity<String> handleEmptyFields(EmptyFieldsException emptyFieldsException) {
		emptyFieldsException.setStatusCode(HttpStatus.BAD_REQUEST);
		emptyFieldsException.setMessage("Please fill up the empty fields!");
		return new ResponseEntity<String>(emptyFieldsException.getMessage(), emptyFieldsException.getStatusCode());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException() {
		return new ResponseEntity<String>("Price and Quantity have to be a positive number greater than 0!",
				HttpStatus.BAD_REQUEST);
	}
}
