package com.kodgemisi.course.ecommerce.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.kodgemisi.course.ecommerce.exceptions.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User userOptional = userRepository.findByUsername(username);
        return userOptional;
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User findById(@Param("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> {
            log.error("user not found by {}", id);
            return new ResourceNotFoundException();
        });
    }

    @Transactional
    public void setEnabled(boolean enabled, Long id) {
        User persistedUser = this.findById(id);
        persistedUser.setEnabled(enabled);
    }
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
