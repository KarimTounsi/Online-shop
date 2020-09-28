package pl.coderslab.project.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.product.Product;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/edit")
@AllArgsConstructor
public class EditUserController {

    UserService userService;


    @GetMapping
    public String editUser(Model model , Principal principal) {
        model.addAttribute("user",userService.findByUserName(principal.getName()));
        return "edit-user-info";
    }


    @PostMapping
    public String editUser(@Valid User user, BindingResult result,Principal principal) {
        if (result.hasErrors()) {
            return "edit-user-info";
        }
        user.setId(userService.findByUserName(principal.getName()).getId());
        user.setPassword(userService.findByUserName(principal.getName()).getPassword());
        userService.updateUser(user);
        return "redirect:/info";
    }}