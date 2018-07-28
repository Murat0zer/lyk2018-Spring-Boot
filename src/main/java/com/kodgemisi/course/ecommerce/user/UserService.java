package com.kodgemisi.course.ecommerce.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
         User userOptional = userRepository.findByUsername(username);
         return userOptional;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
