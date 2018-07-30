package com.kodgemisi.course.ecommerce.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(@Param("username") String username);

    boolean existsByUsername(@Param("username") String username);

    Page<User> findAll(Pageable pageable);



}
