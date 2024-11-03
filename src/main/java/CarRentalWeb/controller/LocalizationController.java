package CarRentalWeb.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.context.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/localization")
public class LocalizationController {

    @Autowired
    private MessageSource messageSource;

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