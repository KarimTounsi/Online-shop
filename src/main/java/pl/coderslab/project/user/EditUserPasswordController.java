package pl.coderslab.project.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;
import pl.coderslab.project.exception.WrongPasswordException;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/edit-password")
@AllArgsConstructor
public class EditUserPasswordController {

    UserService userService;
    CategoryService categoryService;
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
