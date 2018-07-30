package com.kodgemisi.course.ecommerce.Product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
