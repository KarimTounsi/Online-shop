package pl.coderslab.project.user;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;
import pl.coderslab.project.product.Product;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomePageController {

    CategoryService categoryService;
    CartService cartService;



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

    @ModelAttribute("ProductsInCart")
    public int ProductsInCart() {
        return cartService.getAmountProductsInCart();
    }


}
