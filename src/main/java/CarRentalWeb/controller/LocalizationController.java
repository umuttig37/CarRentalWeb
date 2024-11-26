package CarRentalWeb.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/localization")
public class LocalizationController {

    private final MessageSource messageSource;

    public LocalizationController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // This returns the page messages based on the language, country, and page
    @GetMapping("/messages")
    public Map<String, String> getPageMessages(@RequestParam("lang") String lang,
                                               @RequestParam("country") String country,
                                               @RequestParam("page") String page) {
        Locale locale = new Locale(lang, country);
        Map<String, String> messages = new HashMap<>();

        ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);

        bundle.keySet().stream()
                .filter(key -> key.startsWith(page + "."))
                .forEach(key -> messages.put(key, bundle.getString(key)));

        return messages;
    }
}
