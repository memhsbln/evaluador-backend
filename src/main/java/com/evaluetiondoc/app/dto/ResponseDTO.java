package com.evaluetiondoc.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
    private String timestamp;
    private String path;
    private int status;
    private String error;
    private String message;
    private T data;
}

