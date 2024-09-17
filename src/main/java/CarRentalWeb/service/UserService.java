package CarRentalWeb.service;


import CarRentalWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CarRentalWeb.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}

