package com.example.wholesale_system.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * user's controller
 */
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * login function
     *
     * @param user: user type their username and password
     * @return: if user's login data matches user database then will direct to index page, if not will go back to login page
     */
    @PostMapping("/loginByUsername")
    public String loginByUsername(@ModelAttribute("User") Users user) {
        try {
            String userInfo = userService.findUserByUsername(user.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/login";
        }

        return "redirect:/";
    }
}
