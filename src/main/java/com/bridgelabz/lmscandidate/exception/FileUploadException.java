package com.bridgelabz.lmscandidate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bridgelabz.lmscandidate.dto.ResponseDto;

@ControllerAdvice
public class FileUploadException extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<ResponseDto> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto("File too large!"));
	  }
	}
