package com.soa.SecurityMicroservice.controller;

import com.soa.SecurityMicroservice.service.AuthenticationService;
import com.soa.api.UserApi;
import com.soa.model.LoginRequestDto;
import com.soa.model.LoginResponseDto;
import com.soa.model.RegisterRequestDto;
import com.soa.model.RegisterResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AuthenticationController implements UserApi {

    private final AuthenticationService authenticationService;


    @Override
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
        var loginResponse = authenticationService.login(loginRequestDto);
        return ResponseEntity.ok(loginResponse);
    }

    @Override
    public ResponseEntity<RegisterResponseDto> register(RegisterRequestDto registerRequestDto) {
        var registerResponse = authenticationService.register(registerRequestDto);
        return ResponseEntity.ok(registerResponse);
    }
}
