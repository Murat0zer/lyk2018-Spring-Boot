package com.kodgemisi.course.ecommerce;

import com.kodgemisi.course.ecommerce.user.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@SpringBootApplication
public class EcommerceApplication {

    private final RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, RegistrationService registrationService, RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findAll().isEmpty()) {
                roleRepository.save(Role.ADMIN);
                roleRepository.save(Role.USER);
            }

            if (!userService.existsByUsername("admin")) {
                // create new admin
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@email.com");
                admin.setPassword(passwordEncoder().encode("password"));
                admin.setFirstName("admin");
                admin.setLastName("admin");
                Set<Role> roles = new HashSet<>();
                roles.add(roleRepository.findByRoleName(Role.RoleName.ADMIN));

                // Create user has role both admin and user.
                User adminUser = new User();
                adminUser.setUsername("adminuser");
                adminUser.setEmail("adminyser@email.com");
                adminUser.setPassword(passwordEncoder().encode("password"));
                adminUser.setFirstName("adminuser");
                adminUser.setLastName("adminuser");
                Set<Role> adminUserRoles = new HashSet<>();
                adminUserRoles.add(roleRepository.findByRoleName(Role.RoleName.ADMIN));
                adminUserRoles.add(roleRepository.findByRoleName(Role.RoleName.USER));
            }
        };
    }
}