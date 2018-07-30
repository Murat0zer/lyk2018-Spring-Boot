package com.kodgemisi.course.ecommerce.admin;

import com.kodgemisi.course.ecommerce.category.Category;
import com.kodgemisi.course.ecommerce.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CategoryService categoryService;

    @GetMapping
    public String adminDashboard(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/index";
    }

    @PostMapping("/categories")
    public String addNewCategory(@Valid Category category,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            categoryService.save(category);
            redirectAttributes.addFlashAttribute("message","Category Added Successfuly");
        }

        return "redirect:/admin";

    }


}
