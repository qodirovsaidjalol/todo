package uz.qodirov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping ("/auth/logout")
    private String logoutPaged() {
        return "auth/logout";
    }

}
