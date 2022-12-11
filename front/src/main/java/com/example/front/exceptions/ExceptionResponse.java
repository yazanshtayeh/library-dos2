package com.example.front.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
public class ExceptionResponse {
    private String message = "no message available";
    private int type;
    private String error;
    private Timestamp timeStamp;
}