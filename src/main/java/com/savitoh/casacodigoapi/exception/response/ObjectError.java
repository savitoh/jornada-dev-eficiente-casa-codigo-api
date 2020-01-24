package com.savitoh.casacodigoapi.exception.response;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectError {

    private final String message;

    private final String field;

    private final Object parameter;

    public ObjectError(String message, String field, Object parameter) {
        this.message = message;
        this.field = field;
        this.parameter = parameter;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

    public Object getParameter() {
        return parameter;
    }

    public static List<ObjectError> criaDeMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ObjectError(fieldError.getDefaultMessage(), fieldError.getField(), fieldError.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
