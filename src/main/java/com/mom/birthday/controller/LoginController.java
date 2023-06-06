package com.mom.birthday.controller;

import com.mom.birthday.domain.request.LoginRequest;
import com.mom.birthday.domain.dto.TokenDTO;
import com.mom.birthday.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {
    private final UserService userService;

//    @PostMapping("/login")
//    public TokenDTO login(@RequestBody LoginRequest request) {
//        String userId = request.getUserId();
//        String password = request.getPassword();
//        TokenDTO tokenDTO = userService.login(userId, password);
//        return tokenDTO;
//    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginRequest request){
        TokenDTO tokenDTO = userService.login(request.getUserId(), request.getPassword());
        return ResponseEntity.ok(tokenDTO);
    }
}
