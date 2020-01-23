package com.savitoh.casacodigoapi.exception;

import com.savitoh.casacodigoapi.exception.data.ErrorResponse;
import com.savitoh.casacodigoapi.exception.data.ObjectError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ApiExceptionGlobalHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<ObjectError> errors = getErrors(ex);
        ErrorResponse errorResponse = new ErrorResponse("Erro validacao de campos da requisicao",
                                                        status.value(),
                                                        LocalDateTime.now(),
                                                        status,
                                                        errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private List<ObjectError> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ObjectError(fieldError.getDefaultMessage(), fieldError.getField(), fieldError.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
