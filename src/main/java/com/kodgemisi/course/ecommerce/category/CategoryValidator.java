package com.kodgemisi.course.ecommerce.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@AllArgsConstructor
@Component
public class CategoryValidator implements Validator {

    private final CategoryService categoryService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Category.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Category category = (Category) target;

        if (categoryService.existsByName(category.getName())) {
            errors.rejectValue("name", "errors.mustBeUnique.category.name", "Name already exists");

        }
    }
}
