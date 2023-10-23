package com.service.lostFound.Service;

import com.service.lostFound.Dto.SignUpDto;
import com.service.lostFound.Model.SignUp;
import com.service.lostFound.Repository.SignUpProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpProcessService {
    public SignUpProcessService() {
    }

    @Autowired
    private SignUpProcessRepository signUpProcessRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<String> createAccount(SignUpDto signUpDto) {
        try {
            SignUp signUp= new SignUp();
            signUp.setMobileNumber(signUpDto.getMobileNumber());
            signUp.setEmail(signUpDto.getEmail());
            signUp.setFirstName(signUpDto.getFirstName());
            signUp.setLastName(signUpDto.getLastName());
            signUp.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
            signUp.setIsActive(Boolean.TRUE);
            signUp.setIsAdmin(Boolean.TRUE);
            signUpProcessRepository.save(signUp);
            return  new ResponseEntity<>("sucessfully saved", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }

}
