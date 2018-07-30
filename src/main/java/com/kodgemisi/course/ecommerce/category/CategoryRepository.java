package com.kodgemisi.course.ecommerce.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    boolean existsByName(@Param("name") String name);
}
