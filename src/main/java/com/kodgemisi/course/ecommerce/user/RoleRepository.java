package com.kodgemisi.course.ecommerce.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Override
    List<Role> findAll();

    Role findByRoleName(Role.RoleName RoleName);

}
