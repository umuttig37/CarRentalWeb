package CarRentalWeb.controller;

import CarRentalWeb.DTO.UserDTO;
import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class AccessController {

    private final UserRepository userRepository;

    public AccessController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Implement the getProfile method which returns the user profile information
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Principal principal) {
        String username = principal.getName();
        // Assuming default language is "en"
        User user = findByUserName(username);

        if (user != null) {
            return ResponseEntity.ok(new UserDTO(user.getUserName(), user.getUserEmail(), user.getUserFirstName(), user.getUserLastname()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    // Implement the findByUserName method which returns the user by username
    private User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}