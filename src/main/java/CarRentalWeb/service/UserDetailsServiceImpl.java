package CarRentalWeb.service;

import CarRentalWeb.model.User;
import CarRentalWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Assuming default language is "en"
        User user = findByUserName(username, "en");
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getUserPassword(),
                new ArrayList<>()
        );
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getUserPassword(),
                new ArrayList<>()
        );
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