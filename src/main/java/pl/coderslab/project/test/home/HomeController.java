package pl.coderslab.project.test.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.project.test.Person.Person;

@Controller
public class HomeController {

    @GetMapping("/new")
    public String hello(Model model){
        model.addAttribute(new Person("name"));
        return "Test/home";
    }


}
