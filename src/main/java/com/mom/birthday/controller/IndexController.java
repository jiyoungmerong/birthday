package com.mom.birthday.controller;

import com.mom.birthday.domain.User;
import com.mom.birthday.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({ "", "/" })
    public String index() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/join")
    public String joinProc(User user) {
        String rawPassword = user.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/join")
    public String signUpForm() {
        return "join";
    }

    @GetMapping("/message_list")
    public String message(){
        return "message_list";
    }

}
