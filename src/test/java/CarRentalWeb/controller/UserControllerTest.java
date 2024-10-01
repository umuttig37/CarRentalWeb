package CarRentalWeb.controller;

import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import CarRentalWeb.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "testUser")
    public void testRegisterUser() {
        User user = new User();
        user.setUserName("testUser");
        user.setUserPassword("testPass"); // Set password

        ResponseEntity<?> response = userController.registerUser(user);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @WithMockUser(username = "testUser")
    public void testLoginUser() {
        String username = "testUser";
        String password = "testPass";

        User user = new User();
        user.setUserName(username);
        user.setUserPassword(passwordEncoder.encode(password)); // Encode password

        userRepository.save(user);

        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", username);
        credentials.put("password", password);

        ResponseEntity<?> response = userController.loginUser(credentials);

        assertEquals(200, response.getStatusCodeValue());
    }
}