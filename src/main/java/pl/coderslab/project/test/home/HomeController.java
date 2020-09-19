package pl.coderslab.project.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.project.Person.Person;

@Controller
public class HomeController {

    @GetMapping("/new")
    public String hello(Model model){
        model.addAttribute(new Person("name"));
        return "home";
    }


}
