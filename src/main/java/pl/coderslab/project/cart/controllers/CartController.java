package pl.coderslab.project.cart.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.exception.NotEnoughProductsInStockException;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.service.ProductService;

import java.util.List;


@Controller
@RequestMapping
@AllArgsConstructor
public class CartController {

    private final  ProductService productService;
    private final  CartService cartService;
    private final  CategoryService categoryService;

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cart",cartService.getProductsInCart());
        model.addAttribute("cartSum",cartService.getTotal());
        return "cart/cart";
    }



    @PostMapping("/product/add/cart")
    public String AddProductInCart( Long id ) throws NotEnoughProductsInStockException {
           Product product = productService.getProductById(id);
           if (product.getQuantity()>1){
               cartService.addProduct(product);
           }
        return "redirect:/cart";
    }

    @PostMapping("/product/subtract/cart")
    public String productSubtractFromCart( Long id ) {
        Product product = productService.getProductById(id);
        cartService.subtractProduct(product);
        return "redirect:/cart";
    }

    @PostMapping("/product/remove/cart")
    public String productRemoveFromCart( Long id ) {
        Product product = productService.getProductById(id);
        cartService.removeProduct(product);
        return "redirect:/cart";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

    @ModelAttribute("ProductsInCart")
    public int ProductsInCart() {
        return cartService.getAmountProductsInCart();
    }

}
