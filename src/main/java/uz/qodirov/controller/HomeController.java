package uz.qodirov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/", "/home"})
    public String homePage() {
        return "home";
    }

    @GetMapping(value = {"/auth/login"})
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping(value = {"/index"})
    public String index() {
        return "index";
    }

    @GetMapping(value = {"/admin"})
    public String admin() {
        return "admin";
    }
}
