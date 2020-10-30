package pl.coderslab.project.product.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/admin/product/all/deleted")
@AllArgsConstructor
public class viewAllDeletedProductsController {

    private final  ProductService productService;
    private final  CategoryService categoryService;
    private final   CartService cartService;


    @ModelAttribute("products")
    public List<Product> getAll() {
        return productService.getAllByStatus(false);
    }


    @GetMapping
    public String viewProducts() {
        return "product/view-all-deleted-products";
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
