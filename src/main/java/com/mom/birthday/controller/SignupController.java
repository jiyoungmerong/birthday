package com.mom.birthday.controller;

import com.mom.birthday.domain.User;

import com.mom.birthday.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class SignupController {
    private final UserService userService;

//    @PostMapping("/signup")
//    public void postSignup(Model model, @RequestParam("userId") String userId, @RequestParam("name") String name,
//                             @RequestParam("nickname") String nickname, @RequestParam("password") String password) {
//        User user = new User(userId, password, name, nickname);
//        model.addAttribute("userId", userId);
//        model.addAttribute("name", name);
//        model.addAttribute("nickname", nickname);
//        model.addAttribute("password", password);
//        model.addAttribute("user", user);
//        userService.signup(userId, name, nickname, password);
//    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute("user") User user) {
        userService.signup(user);
        return "redirect:/main";
    }
}
