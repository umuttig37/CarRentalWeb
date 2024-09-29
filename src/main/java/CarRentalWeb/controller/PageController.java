package CarRentalWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("")
    public String homePage() {
        return "home";
    }

    @GetMapping("/rental")
    public String rentalPage() {
        return "rental";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "search-results";
    }

    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }
}