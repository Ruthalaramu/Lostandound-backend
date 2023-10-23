package com.service.lostFound.Handler;


import com.service.lostFound.Dto.SignUpOtpValidationDto;
import com.service.lostFound.Dto.SignupOtpRequestDto;
import com.service.lostFound.Dto.SignupResponseOtpDto;
import com.service.lostFound.Service.OtpProcessService;
import org.springframework.beans.factory.annotation.Autowired;

public class OtpProcessHandler {

    private OtpProcessService otpProcessService;

    public OtpProcessHandler(OtpProcessService otpProcessService) {
        this.otpProcessService = otpProcessService;
    }

    public SignupResponseOtpDto sendSMS(SignupOtpRequestDto signupOtpRequestDto) {
        return otpProcessService.sendSMS(signupOtpRequestDto);
    }
    public String otpValidation(SignUpOtpValidationDto signUpOtpValidation) {
        return otpProcessService.otpValidation(signUpOtpValidation);
    }
}
