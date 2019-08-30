package pl.adam.database.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GymMemberRestExceptionHandler {

	// add an exception handler for GymMemberNotFoundException
	@ExceptionHandler
	public ResponseEntity<GymMemberErrorResponse> handleException(GymMemberNotFoundException e) {

		// create CustomerErrorResponse
		GymMemberErrorResponse error = new GymMemberErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler -> to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<GymMemberErrorResponse> handleException(Exception e) {

		// create GymMemberErrorResponse
		// bad_request -> 400 error
		GymMemberErrorResponse error = new GymMemberErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
