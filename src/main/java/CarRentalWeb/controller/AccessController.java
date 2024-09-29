package CarRentalWeb.controller;

import CarRentalWeb.DTO.UserDTO;
import CarRentalWeb.model.AuthenticationResponse;
import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CarRentalWeb.Util.JwtUtil;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class AccessController {

    private final UserRepository userRepository;

    public AccessController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUserName(username);

        if (user != null) {
            return ResponseEntity.ok(new UserDTO(user.getUserName(), user.getUserEmail(), user.getUserFirstName(), user.getUserFirstName()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}