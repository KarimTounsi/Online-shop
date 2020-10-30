package pl.coderslab.project.product.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/all")
@AllArgsConstructor
public class viewAllProductsController {

ProductService productService;
    CategoryService categoryService;
    CartService cartService;


    @ModelAttribute("products")
    public List<Product> getAll() {
        return productService.getAllByStatus(true);
    }


    @GetMapping
    public String viewProducts() {
        return "product/view-all-products";
    }

    @PostMapping
    public String viewProductsBySort(Model model, String type) {
        if (type.equals("increase")) {
            model.addAttribute("products", productService.getAllByOrderByPriceAsc());
        } else if (type.equals("decrease")){
            model.addAttribute("products", productService.getAllByOrderByPriceDesc());
        } else if (type.equals("A-Z")){
            model.addAttribute("products", productService.getAllByOrderByNameAsc());
        }else if (type.equals("Z-A")){
            model.addAttribute("products", productService.getAllByOrderByNameDsc());
        }

        return "product/view-all-products";
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
