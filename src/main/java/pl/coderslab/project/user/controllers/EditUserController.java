package pl.coderslab.project.user.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.user.entity.User;
import pl.coderslab.project.user.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/edit")
@AllArgsConstructor
public class EditUserController {

    UserService userService;
    CategoryService categoryService;


    @GetMapping
    public String editUser(Model model , Principal principal) {
        model.addAttribute("user",userService.findByUserName(principal.getName()));
        return "user/edit-user-info";
    }


    @PostMapping
    public String editUser(@Valid User user, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "user/edit-user-info";
        }
        user.setId(userService.findByUserName(principal.getName()).getId());
        user.setPassword(userService.findByUserName(principal.getName()).getPassword());
        userService.updateUser(user);

        return "redirect:/info";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }
}
