package com.savitoh.casacodigoapi.exception;

import com.savitoh.casacodigoapi.exception.response.ErrorResponse;
import com.savitoh.casacodigoapi.exception.response.ObjectError;
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

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        List<ObjectError> errors = ObjectError.criaDeMethodArgumentNotValidException(ex);
        ErrorResponse errorResponse = new ErrorResponse("Erro validacao de campos da requisicao",
                                                        status.value(),
                                                        LocalDateTime.now(),
                                                        status,
                                                        errors);
        return new ResponseEntity<>(errorResponse, status);
    }

}
