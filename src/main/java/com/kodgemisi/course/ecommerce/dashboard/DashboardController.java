package com.kodgemisi.course.ecommerce.dashboard;

import com.kodgemisi.course.ecommerce.Product.Product;
import com.kodgemisi.course.ecommerce.Product.ProductService;
import com.kodgemisi.course.ecommerce.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class DashboardController {

    private final ProductService productService;
    @GetMapping
    public String dasboard(Model model, @AuthenticationPrincipal User user, Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        model.addAttribute("user", user);
        return "dashboard/index";
    }
//
//    @GetMapping(/profile)
//    public String profile(Model model, @AuthenticationPrincipal User user) {
//
//    }
}
