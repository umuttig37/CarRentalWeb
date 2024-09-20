package CarRentalWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "Login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "Register";
    }

    @GetMapping("/home")
    public String homePage() { return "home"; }
}