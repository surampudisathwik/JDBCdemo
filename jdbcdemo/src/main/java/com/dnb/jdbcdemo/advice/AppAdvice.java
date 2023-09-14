package com.dnb.jdbcdemo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dnb.jdbcdemo.demo.exceptions.DataNotFoundException;
import com.dnb.jdbcdemo.demo.exceptions.IdNotFoundException;

@ControllerAdvice
public class AppAdvice {
	//Global exception handler
	@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<?> InvalidIdExceptionHandler (IdNotFoundException e){
	Map<String, String> map = new HashMap<>();
	map.put("message", e.getMessage());
	map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
	return new ResponseEntity(map,HttpStatus.NOT_FOUND);
}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> DataNotFoundExceptionHandler (DataNotFoundException e){
		Map<String, String> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("HttpStatus", HttpStatus.NOT_FOUND+"");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND);
	}
	
}

