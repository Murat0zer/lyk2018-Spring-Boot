package com.kodgemisi.course.ecommerce.category;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.kodgemisi.course.ecommerce.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return (List<Category>)  categoryRepository.findAll();
    }

    public void saveAll(List<Category> categories){
        categoryRepository.saveAll(categories);
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElseThrow(() ->{
            log.error("Category not found by id {}", id);
            return new ResourceNotFoundException();
        });
    }

    public boolean existsByName(String name) {
        return  categoryRepository.existsByName(name);
    }
}
