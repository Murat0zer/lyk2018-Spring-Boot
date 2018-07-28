package com.kodgemisi.course.ecommerce.dashboard;

import com.kodgemisi.course.ecommerce.user.User;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardController {

    @GetMapping
    public String dasboard(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "dashboard/index";
    }
//
//    @GetMapping(/profile)
//    public String profile(Model model, @AuthenticationPrincipal User user) {
//
//    }
}
