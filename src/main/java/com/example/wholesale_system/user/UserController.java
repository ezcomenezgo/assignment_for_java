package com.example.wholesale_system.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/loginByUsername")
    public String loginByUsername(@ModelAttribute("User") Users user) {
        try {
            userService.findUserByUsername(user.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/login";
        }

        return "redirect:/";
    }
}
