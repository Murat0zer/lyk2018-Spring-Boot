package com.kodgemisi.course.ecommerce.user;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Role implements GrantedAuthority {

    public static final Role ADMIN = new Role(RoleName.ADMIN);
    public static final Role USER = new Role(RoleName.USER);
    @Id
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleName roleName;

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return this.roleName.name();
    }

    public enum RoleName {
        ADMIN, USER
    }

}
