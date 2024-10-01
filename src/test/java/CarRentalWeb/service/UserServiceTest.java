// src/test/java/CarRentalWeb/service/UserServiceTest.java
package CarRentalWeb.service;

import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setUserName("testUser");
        user.setUserPassword("testPass"); // Set password

        User registeredUser = userService.registerUser(user);
        assertNotNull(registeredUser);
        assertEquals("testUser", registeredUser.getUserName());
    }

    @Test
    public void testLoginUser() {
        String username = "testUser";
        String password = "testPass";

        User user = new User();
        user.setUserName(username);
        user.setUserPassword(userService.passwordEncoder.encode(password)); // Encode password

        userRepository.save(user);

        User loggedInUser = userService.loginUser(username, password);
        assertNotNull(loggedInUser);
        assertEquals(username, loggedInUser.getUserName());
    }
}