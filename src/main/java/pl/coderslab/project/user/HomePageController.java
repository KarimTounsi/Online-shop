package pl.coderslab.project.user;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")

public class HomePageController {

    CategoryService categoryService;

    public HomePageController(@Qualifier("categoryServiceImpl") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String prepareHomePage(Model model ,  Principal principal) {
return "home-page";
    }

//    @GetMapping("/admin")
//    @ResponseBody
//    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
//        User entityUser = customUser.getUser();
//        return "Hello " + entityUser.getUsername();
//    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

}
