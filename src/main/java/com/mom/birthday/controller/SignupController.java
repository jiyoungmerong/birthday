package com.mom.birthday.controller;

import com.mom.birthday.domain.request.SignupRequest;
import com.mom.birthday.domain.response.SignupResponse;
import com.mom.birthday.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;


    @PostMapping("/signup")
    public ApiResponseDto<SignupResponse>



}
