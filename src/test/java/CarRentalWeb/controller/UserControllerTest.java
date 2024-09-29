package CarRentalWeb.controller;

import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import CarRentalWeb.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.ResponseEntity;

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

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }
/*
    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setUserName("testUser");

        ResponseEntity<?> response = userController.registerUser(user);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testLoginUser() {
        String username = "testUser";
        String password = "testPass";

        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);

        userRepository.save(user);

        ResponseEntity<?> response = userController.loginUser(username, password);
        assertEquals(200, response.getStatusCodeValue());
    }
    */
}