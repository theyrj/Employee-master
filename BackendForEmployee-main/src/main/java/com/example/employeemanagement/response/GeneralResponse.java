package com.example.employeemanagement.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Data
public class GeneralResponse {

    private HttpStatus status;
    private String message;
    private Object data;

    public GeneralResponse(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public GeneralResponse(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}