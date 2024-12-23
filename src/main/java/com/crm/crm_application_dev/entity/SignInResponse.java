package com.crm.crm_application_dev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SignInResponse {

    private int status;
    private String message;

    public SignInResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
