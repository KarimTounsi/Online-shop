package pl.coderslab.project.user.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.exception.WrongPasswordException;
import pl.coderslab.project.user.entity.User;
import pl.coderslab.project.user.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/edit-password")
@AllArgsConstructor
public class EditUserPasswordController {

    private final  UserService userService;
    private final  CategoryService categoryService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String editUserPassword() {
        return "user/edit-user-password";
    }


    @PostMapping
    public String editUserPassword(Principal principal, String password, String newPassword ) throws WrongPasswordException {

        User user = userService.findByUserName(principal.getName());
        if (passwordEncoder.matches(password,user.getPassword())) {
            user.setPassword(newPassword);
//        user.setId(userService.findByUserName(principal.getName()).getId());
            userService.saveUser(user);
        } else {
            throw new WrongPasswordException(user);
        }


        return "redirect:/info";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }
}
