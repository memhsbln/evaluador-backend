package com.evaluetiondoc.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    private String timestamp;
    private String path;
    private int status;
    private String error;
    private String message;
    private T data;
}

