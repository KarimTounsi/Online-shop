package pl.coderslab.project.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomePageController {

UserRepository userRepository;

    @GetMapping
    public String prepareHomePage(Model model ,  Principal principal) {
return "home-page";
    }

//    @PostMapping("/add-advert-to-observed")
//    public String addToObserved(@RequestParam Long advertId, Principal principal) {
////        String userName =  principal.getName();
////        User user = userRepository.findByUsername(userName);
////        userRepository.save(user);
//        return "redirect:/";
//    }
//
//    @PostMapping("/subtract-advert-to-observed")
//    public String subtractToObserved(@RequestParam Long advertId, Principal principal) {
//        String userName =  principal.getName();
//        User user = userRepository.findByUsername(userName);
////        userRepository.save(user);
//        return "redirect:/";
//    }


}
