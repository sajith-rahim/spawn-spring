package com.template.spawn.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.minidev.json.JSONObject;

@ControllerAdvice
public class GenericExceptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> methodArgumentNotValidException(Exception ex) {
		final var response = new JSONObject();
		response.put("status", HttpStatus.BAD_REQUEST);
		response.put("message", "Oops!");
		response.put("timestamp", LocalDateTime.now().toString());
		return ResponseEntity.badRequest().body(response.toString());
	}
	

	

}