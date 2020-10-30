package pl.coderslab.project.user.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.service.ProductService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomePageController {

    private final  CategoryService categoryService;
    private final  CartService cartService;
    private final  ProductService productService;



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
