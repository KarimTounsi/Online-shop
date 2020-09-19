package pl.honestit.spring.demo.Controllers;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.honestit.spring.demo.model.domain.User;
import pl.honestit.spring.demo.model.repositories.UserRepository;


@Controller
@RequestMapping("/register")
@AllArgsConstructor
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Konfiguracja Logger'a
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);



    @GetMapping
    public String prepareRegistrationPage() {
        return "registration-form";
    }

    @PostMapping
    public String processRegistrationPage(String username,
                                          String password,
                                          String firstName, String lastName) {
        User user = new User();
        user.setUsername(username);
        user.setFirstName(firstName);
        String encdoedPassword = passwordEncoder.encode(password);
        user.setPassword(encdoedPassword);
        user.setLastName(lastName);
        user.setActive(true);
        userRepository.save(user);
        log.info("Zapisany użytkownik: " + user);
        return "redirect:/";
    }
}
