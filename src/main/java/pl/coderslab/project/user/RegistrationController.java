package pl.coderslab.project.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;



@Controller
@RequestMapping("/register")

public class RegistrationController {

    private final UserService userService;

    public RegistrationController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    // Konfiguracja Logger'a
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);



    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration-form";
    }

    @PostMapping
    public String processRegistrationPage(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "registration-form";
        }
        userService.saveUser(user);
        log.info("Zapisany użytkownik: " + user);
        return "redirect:/login";
    }



}
