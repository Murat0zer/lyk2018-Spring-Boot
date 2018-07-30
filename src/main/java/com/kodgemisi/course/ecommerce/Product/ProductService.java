package com.kodgemisi.course.ecommerce.Product;

import com.kodgemisi.course.ecommerce.category.Category;
import com.kodgemisi.course.ecommerce.category.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.kodgemisi.course.ecommerce.exceptions.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void saveAll(List<Product> productList) {
        productRepository.saveAll(productList);
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> {
            log.error("product can not be found {}", id);
            return new ResourceNotFoundException();
        });
    }

    public Product save(ProductDto productDto) {
        Category category = categoryService.findById(productDto.getCategoryId());
        Product product = Product.builder()
                .category(category)
                .name(productDto.getName())
                .creationDate(LocalDate.now())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .url(productDto.getUrl())
                .build();
        productRepository.save(product);
        return product;
    }

    public void newProduct(Product product){
        productRepository.save(product);

    }
}
