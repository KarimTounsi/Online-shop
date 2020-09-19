package pl.honestit.spring.demo.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.honestit.spring.demo.model.domain.User;
import pl.honestit.spring.demo.model.repositories.AdvertRepository;
import pl.honestit.spring.demo.model.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomePageController {

AdvertRepository advertRepository;

UserRepository userRepository;


    @GetMapping
    public String prepareHomePage(Model model ,  Principal principal) {

        if (principal !=null){
            model.addAttribute("adverts", advertRepository.findAllByOrderByPostedDesc());
        } else {
            model.addAttribute("adverts", advertRepository.findFirst10ByOrderByPostedDesc());
        }

return "home-page";
    }



    @PostMapping("/add-advert-to-observed")
    public String addToObserved(@RequestParam Long advertId, Principal principal) {
        String userName =  principal.getName();
        User user = userRepository.findByUsername(userName);
        user.getObservedAdverts().add(advertRepository.findById(advertId).get());
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/subtract-advert-to-observed")
    public String subtractToObserved(@RequestParam Long advertId, Principal principal) {
        String userName =  principal.getName();
        User user = userRepository.findByUsername(userName);
        user.getObservedAdverts().remove(advertRepository.findById(advertId).get());
        userRepository.save(user);
        return "redirect:/";
    }


}
