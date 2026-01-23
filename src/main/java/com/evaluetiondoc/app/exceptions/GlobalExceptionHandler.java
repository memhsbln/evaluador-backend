package com.evaluetiondoc.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.evaluetiondoc.app.dto.ResponseDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @ExceptionHandler({
        EmailYaRegistradoException.class,
        NombreUsuarioYaRegistradoException.class,
        CredencialesInvalidasException.class,
        RefreshTokenInvalidoException.class
    })
    public ResponseEntity<ResponseDTO<Object>> handleBusinessExceptions(RuntimeException ex, WebRequest request) {
        ResponseDTO<Object> response = new ResponseDTO<>(
                now(),
                request.getDescription(false).replace("uri=", ""),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                null
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<Object>> handleAll(Exception ex, WebRequest request) {
        ResponseDTO<Object> response = new ResponseDTO<>(
                now(),
                request.getDescription(false).replace("uri=", ""),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
