package com.example.dentalOffice.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    private static final Logger logger = Logger.getLogger(GlobalExceptions.class);

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> processBadRequestError(ResourceNotFoundException ex) {
        logger.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processResourceNotFound(ResourceNotFoundException ex) {
        logger.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allError(Exception ex) {
        logger.error(ex.getMessage());
        return new ResponseEntity("ExceptionHandler Error " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
