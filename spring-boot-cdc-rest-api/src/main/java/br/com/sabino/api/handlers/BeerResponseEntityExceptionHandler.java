package br.com.sabino.api.handlers;

import br.com.sabino.api.handlers.errors.ErrorDetails;
import br.com.sabino.api.handlers.exception.BeerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BeerResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BeerNotFoundException.class)
    public final ResponseEntity<Object> handleJsonParseException(BeerNotFoundException exception) {
        final var errorDetails = new ErrorDetails(exception.getMessage());
        return new ResponseEntity<>(errorDetails.getMessage(), HttpStatus.NOT_FOUND);
    }
}
