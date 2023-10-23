package com.service.lostFound.Handler;

import com.service.lostFound.Dto.SignUpDto;
import com.service.lostFound.Model.SignUp;
import com.service.lostFound.Service.SignUpProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class SignUpProcessHandler {
    public SignUpProcessHandler() {
    }

    private SignUpProcessService signUpProcessService;

    public SignUpProcessHandler(SignUpProcessService signUpProcessService) {
        this.signUpProcessService = signUpProcessService;
    }
    public ResponseEntity<String> createAccount(SignUpDto signUpDto) {
        return signUpProcessService.createAccount(signUpDto);
    }
}
