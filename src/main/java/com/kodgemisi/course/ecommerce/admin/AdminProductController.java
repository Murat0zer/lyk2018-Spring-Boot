package com.kodgemisi.course.ecommerce.admin;

import com.kodgemisi.course.ecommerce.Product.Product;
import com.kodgemisi.course.ecommerce.Product.ProductDto;
import com.kodgemisi.course.ecommerce.Product.ProductService;
import com.kodgemisi.course.ecommerce.category.Category;
import com.kodgemisi.course.ecommerce.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    @GetMapping
    public String index(Model model, Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "admin/product/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable Long id) {
        Product product = productService.findById(id);
        model.addAttribute(product);
        return "admin/product/show/";
    }

    @GetMapping("/new")
    public String listProducts(Model model) {
        ProductDto productDto = new ProductDto();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("productDto", productDto);
        model.addAttribute("categories", categories);
        return "/admin/product/new";
    }

    @PostMapping
    public String create(@Valid ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/product/new";
        }
        Product product = productService.save(productDto);
        return "redirect:/products/show/" + product.getId();


    }

}
