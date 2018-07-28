package com.kodgemisi.course.ecommerce.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class RegistrationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder bCryptPasswordEncoder;

    void createUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());

        String encodedPassword = bCryptPasswordEncoder.encode(registrationDto.getPassword());
        user.setPassword(encodedPassword);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(Role.RoleName.USER));
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user) {
        userRepository.save(user);

    }

    public void createAdminUser(User user) {
        userRepository.save(user);
    }
}
