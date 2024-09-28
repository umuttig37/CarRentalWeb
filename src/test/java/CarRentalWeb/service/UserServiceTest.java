package CarRentalWeb.service;

import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        User registeredUser = userService.registerUser(user);
        assertEquals("testUser", registeredUser.getUserName());
    }

    @Test
    public void testLoginUser() {
        String username = "testUser";
        String password = "testPass";

        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);

        userRepository.save(user);

        User loggedInUser = userService.loginUser(username, password);
        assertEquals(username, loggedInUser.getUserName());
    }
}