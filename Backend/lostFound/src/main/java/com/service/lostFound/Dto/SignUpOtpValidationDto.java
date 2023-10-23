package com.service.lostFound.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpOtpValidationDto {
    private String mobileNumber;
    private String userOtp;
}
