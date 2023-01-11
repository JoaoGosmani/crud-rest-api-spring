package br.com.joaogosmani.crudrestapi.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.joaogosmani.crudrestapi.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String error = "Não encontrado";
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), error, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
