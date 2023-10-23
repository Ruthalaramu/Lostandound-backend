package com.service.lostFound.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseOtpDto {
    private otpStatus userName;
    private String message;

    public SignupResponseOtpDto(otpStatus userName, String otpMessage) {
        this.userName = userName;
        this.message = message;
    }
}
