package com.service.lostFound.Dto;

import lombok.Data;

@Data
public class SignupOtpRequestDto {
    private String mobileNumber;
    private String userName;
    private String otp;
}
