package pl.coderslab.project.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/edit-password")
@AllArgsConstructor
public class EditUserPasswordController {

    UserService userService;


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
}
