package com.service.lostFound.Controller;


import com.service.lostFound.Dto.SignUpOtpValidationDto;
import com.service.lostFound.Dto.SignupOtpRequestDto;
import com.service.lostFound.Dto.SignupResponseOtpDto;
import com.service.lostFound.Handler.OtpProcessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/OTP")
@Slf4j
public class OtpController {
    public OtpController() {
    }
    private OtpProcessHandler otpProcessHandler;

    public OtpController(OtpProcessHandler otpProcessHandler) {
        this.otpProcessHandler = otpProcessHandler;
    }

    @PostMapping("/sendOtp")
    public SignupResponseOtpDto sendOtp(@RequestBody SignupOtpRequestDto signupOtpRequestDto){
        return  otpProcessHandler.sendSMS(signupOtpRequestDto);
    }
    @PostMapping("/ValidateOtp")
    public String ValidateOtp(@RequestBody SignUpOtpValidationDto signUpOtpValidationDto ){

        return otpProcessHandler.otpValidation(signUpOtpValidationDto);
    }
}
