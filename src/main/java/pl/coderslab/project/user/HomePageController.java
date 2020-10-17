package pl.coderslab.project.user;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;
import pl.coderslab.project.product.Product;
import pl.coderslab.project.product.ProductService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomePageController {

    CategoryService categoryService;
    CartService cartService;
    ProductService productService;



    @GetMapping
    public String prepareHomePage(Model model ,  Principal principal) {
        return "/user/home-page";
    }


    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

    @ModelAttribute("ProductsInCart")
    public int ProductsInCart() {
        return cartService.getAmountProductsInCart();
    }

    @ModelAttribute("LastSixProducts")
    public List <Product> LastSixProducts() {
        return productService.getLastSixProducts();
    }


}
