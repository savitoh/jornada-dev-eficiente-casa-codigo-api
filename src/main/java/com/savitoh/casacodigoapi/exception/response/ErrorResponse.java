package com.savitoh.casacodigoapi.exception.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String message;

    private int status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    private HttpStatus httpStatus;

    private List<ObjectError> objectErrors;


    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message, int status, LocalDateTime timestamp,
                         HttpStatus httpStatus, List<ObjectError> objectErrors) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.httpStatus = httpStatus;
        this.objectErrors = objectErrors;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public List<ObjectError> getObjectErrors() {
        return objectErrors;
    }
}
