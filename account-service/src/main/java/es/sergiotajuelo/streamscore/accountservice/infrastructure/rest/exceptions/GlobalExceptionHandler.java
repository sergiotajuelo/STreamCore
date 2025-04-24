package es.sergiotajuelo.streamscore.accountservice.infrastructure.rest.exceptions;

import es.sergiotajuelo.streamscore.accountservice.domain.exceptions.*;
import es.sergiotajuelo.streamscore.accountservice.domain.exceptions.dto.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;


    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleAccountNotFoundException(
            AccountNotFoundException ex, WebRequest request) {
        return buildResponseEntity(ex, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(AccountNotActiveException.class)
    public ResponseEntity<ApiErrorResponse> handleAccountNotActiveException(
            AccountNotActiveException ex, WebRequest request) {
        return buildResponseEntity(ex, HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ApiErrorResponse> handleInsufficientBalanceException(
            InsufficientBalanceException ex, WebRequest request) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(DailyLimitExceededException.class)
    public ResponseEntity<ApiErrorResponse> handleDailyLimitExceededException(
            DailyLimitExceededException ex, WebRequest request) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(InvalidAccountOperationException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidAccountOperationException(
            InvalidAccountOperationException ex, WebRequest request) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(InvalidCurrencyException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCurrencyException(
            InvalidCurrencyException ex, WebRequest request) {
        return buildResponseEntity(ex, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusinessException(
            BusinessException ex, WebRequest request) {
        return buildResponseEntity(ex, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now().format(FORMATTER))
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message("Validation error: " + errorMessage)
                .path(request.getDescription(false).replace("uri=", ""))
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            WebRequest request) {

        String errorMessage = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));

        return buildResponseEntity(
                ex,
                HttpStatus.BAD_REQUEST,
                request,
                "Validation error - " + errorMessage);
    }

    private ResponseEntity<ApiErrorResponse> buildResponseEntity(
            Exception ex, 
            HttpStatus status, 
            WebRequest request) {
        return buildResponseEntity(ex, status, request, ex.getMessage());
    }

    private ResponseEntity<ApiErrorResponse> buildResponseEntity(
            Exception ex, 
            HttpStatus status, 
            WebRequest request, 
            String message) {
        
        String path = request.getDescription(false).replace("uri=", "");
        
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now().format(FORMATTER))
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .path(path)
                .build();
        
        return new ResponseEntity<>(errorResponse, status);
    }
}