package CarRentalWeb.controller;

import CarRentalWeb.model.AuthenticationResponse;
import CarRentalWeb.model.User;
import CarRentalWeb.service.UserService;
import CarRentalWeb.Util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

// This is the controller for the user endpoints
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }
    // This method uses the UserService to register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setUserLastname(user.getUserLastname());
        user.setUserFirstName(user.getUserFirstName());
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }
    // This method uses the UserService to login a user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginDetails) {
        String username = loginDetails.get("username");
        String password = loginDetails.get("password");
        User user = userService.loginUser(username, password);
        if (user != null) {
            user.setUserLastname(user.getUserLastname());
            user.setUserFirstName(user.getUserFirstName());
            // Generate the token using the username
            String token = jwtUtil.generateToken(user.getUserName());

            // Create the AuthenticationResponse object
            AuthenticationResponse response = new AuthenticationResponse();
            response.setUsername(user.getUserName());
            response.setEmail(user.getUserEmail());
            response.setToken(token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
