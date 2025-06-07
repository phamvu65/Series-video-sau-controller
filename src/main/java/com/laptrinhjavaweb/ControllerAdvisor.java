package com.laptrinhjavaweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.laptrinhjavaweb.customexception.FieldRequiredException;
import com.laptrinhjavaweb.model.response.ResponseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler  {
	@ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ResponseDTO> handleArithmeticException(ArithmeticException ex, WebRequest request) {
		ResponseDTO result = new ResponseDTO();
		result.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		details.add("Sao mà 1 số có thể chia cho 0 được");
		result.setDetails(details);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<ResponseDTO> handleFieldRequiredException(FieldRequiredException ex, WebRequest request) {
		ResponseDTO result = new ResponseDTO();
		result.setError(ex.getMessage());
		List<String> details = new ArrayList<>();
		result.setDetails(details);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
	
}






















