package com.kodgemisi.course.ecommerce.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(@Param("username") String username);

    boolean existsByUsername(@Param("username") String username);



}
