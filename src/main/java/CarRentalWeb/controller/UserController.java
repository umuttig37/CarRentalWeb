package CarRentalWeb.controller;

import CarRentalWeb.model.AuthenticationResponse;
import CarRentalWeb.model.User;
import CarRentalWeb.service.UserService;
import CarRentalWeb.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setUserLastname(user.getUserLastname());
        user.setUserFirstName(user.getUserFirstName());
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginDetails) {
        System.out.println("loginDetails: " + loginDetails);
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