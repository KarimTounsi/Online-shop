package pl.coderslab.project.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/edit-password")
@AllArgsConstructor
public class EditUserPasswordController {

    UserService userService;
    CategoryService categoryService;


    @GetMapping
    public String editUserPassword(Model model , Principal principal) {
        model.addAttribute("user",userService.findByUserName(principal.getName()));
        return "edit-user-password";
    }


    @PostMapping
    public String editUserPassword(@Valid User user, BindingResult result,Principal principal) {
        if (result.hasErrors()) {
            return "edit-user-password";
        }
        user.setId(userService.findByUserName(principal.getName()).getId());
        userService.saveUser(user);
        return "redirect:/info";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }
}
