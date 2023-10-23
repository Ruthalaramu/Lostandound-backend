package com.service.lostFound.Service;

import com.service.lostFound.Config.TwilioConfig;
import com.service.lostFound.Dto.SignUpOtpValidationDto;

import com.service.lostFound.Dto.SignupOtpRequestDto;
import com.service.lostFound.Dto.SignupResponseOtpDto;
import com.service.lostFound.Dto.otpStatus;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OtpProcessService {

    private TwilioConfig twilioConfig;

    public OtpProcessService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }


    private SignUpOtpValidationDto signUpOtpValidationDto;

    public OtpProcessService(SignUpOtpValidationDto signUpOtpValidationDto) {
        this.signUpOtpValidationDto = signUpOtpValidationDto;
    }

    Map<String, String> otpMap = new HashMap<>();
    public SignupResponseOtpDto sendSMS(SignupOtpRequestDto signupOtpRequestDto) {
        SignupResponseOtpDto signupResponseOtpDto=null;
        try {
            PhoneNumber to = new PhoneNumber(signupOtpRequestDto.getMobileNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTailNumber());
            String otp = generateOtp();
            String otpMessage = "Use this Otp for the Account Verificatiom:" + otp;
            Message message = Message.creator(to, from, otpMessage).create();
            otpMap.put(signupOtpRequestDto.getMobileNumber(), otp);
            signupResponseOtpDto = new SignupResponseOtpDto(otpStatus.DELIVERED,otpMessage);
        } catch (Exception e) {
            signupResponseOtpDto = new SignupResponseOtpDto(otpStatus.FAILED,e.getMessage());
        }
        return signupResponseOtpDto;
    }
    private String generateOtp(){
        return  new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
    public String otpValidation(SignUpOtpValidationDto signUpOtpValidation) {
        if(signUpOtpValidation.getUserOtp().equals(otpMap.get(signUpOtpValidation.getMobileNumber()))){
              return "otp success";

        }
        else{
            return "otp invalid";
        }


    }
}
