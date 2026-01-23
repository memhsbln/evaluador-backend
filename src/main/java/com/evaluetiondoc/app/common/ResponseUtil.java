package com.evaluetiondoc.app.common;

import com.evaluetiondoc.app.dto.ResponseDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseUtil {
    private ResponseUtil() {}

    public static <T> ResponseDTO<T> ok(String message, T data) {
        return ResponseDTO.<T>builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .status(200)
                .error(null)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ResponseDTO<T> ok(String path, String message, T data) {
        return ResponseDTO.<T>builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .path(path)
                .status(200)
                .error(null)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ResponseDTO<T> ok(T data) {
        return ResponseDTO.<T>builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                .status(200)
                .error(null)
                .message("OK")
                .data(data)
                .build();
    }


}

