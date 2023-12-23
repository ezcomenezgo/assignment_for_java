package com.example.wholesale_system;

import com.example.wholesale_system.user.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * controller of the wholesale_system application
 */
@Controller
public class MainController {
    /**
     * go to login page
     *
     * @param model: add an empty user object to the interface
     * @return: show the login form
     */
    @GetMapping("/login")
    public String login(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "login";
    }
}
