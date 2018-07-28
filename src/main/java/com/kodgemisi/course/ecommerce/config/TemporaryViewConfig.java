package com.kodgemisi.course.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class TemporaryViewConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/cart").setViewName("cart");
        registry.addViewController("/checkout").setViewName("checkout");
        registry.addViewController("/product-details").setViewName("product-details");
        registry.addViewController("/login").setViewName("login");
    }
}
