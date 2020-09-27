package pl.coderslab.project.user;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;

@Controller
@RequestMapping("/info")
@AllArgsConstructor
public class infoUserController {
    UserService userService;


    @GetMapping
    public String prepareHomePage(Model model, Principal principal) {
        String name = principal.getName();
      User user =  userService.findByUserName(name);
        model.addAttribute("user",user);
        return "info-account";
    }


}
