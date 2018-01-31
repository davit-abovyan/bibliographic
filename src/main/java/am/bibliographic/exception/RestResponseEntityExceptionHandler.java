package am.bibliographic.exception;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger log = Logger.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Incorrect argument values provided",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = DuplicateKeyException.class )
    protected ResponseEntity<Object> duplicateKey(DuplicateKeyException ex, WebRequest request) {
        String bodyOfResponse = ex.getCause().getMessage();
        log.warn(ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = NoSuchRecordToRemove.class )
    protected ResponseEntity<Object> removingNotExisitingRecord(NoSuchRecordToRemove ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        log.warn(ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class )
    protected ResponseEntity<Object> emptyGetResult(EmptyResultDataAccessException ex, WebRequest request) {
        return handleExceptionInternal(ex, "{}",
                new HttpHeaders(), HttpStatus.OK, request);
    }
}