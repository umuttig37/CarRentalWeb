package CarRentalWeb.service;

import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userRepository.save(user);
    }

    public User loginUser(String username, String userpassword, String language) {
        System.out.println("username: " + username + " userpassword: " + userpassword);
        if (userpassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        System.out.println("rawPassword: " + userpassword);
        User user = findByUserName(username, language);
        if (user != null && passwordEncoder.matches(userpassword, user.getUserPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Assuming default language is "en"
        User user = findByUserName(username, "en");
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getUserPassword())
                .authorities(new ArrayList<>())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    private User findByUserName(String username, String language) {
        switch (language) {
            case "fi": return userRepository.findByUserNameFi(username);
            case "en": return userRepository.findByUserNameEn(username);
            case "fr": return userRepository.findByUserNameFr(username);
            case "jp": return userRepository.findByUserNameJp(username);
            case "zh": return userRepository.findByUserNameZh(username);
            default: return null;
        }
    }
}