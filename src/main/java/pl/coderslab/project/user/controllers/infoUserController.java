package pl.coderslab.project.user.controllers;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.user.entity.User;
import pl.coderslab.project.user.service.UserService;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/info")
@AllArgsConstructor
public class infoUserController {

    private final  UserService userService;
    private final  CategoryService categoryService;

    @GetMapping
    public String prepareHomePage(Model model, Principal principal) {
        String name = principal.getName();
      User user =  userService.findByUserName(name);
        model.addAttribute("user",user);
        return "user/info-account";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

}
