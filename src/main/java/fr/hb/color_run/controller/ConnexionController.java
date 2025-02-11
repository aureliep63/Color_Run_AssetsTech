package fr.hb.color_run.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class ConnexionController {


    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }



    @GetMapping("/logout")
    public String logout() {
        return "redirect:/auth/login?logout";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
}