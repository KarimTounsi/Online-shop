package pl.coderslab.project.product.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.product.service.ProductService;

import java.util.List;


@Controller
@RequestMapping("/products-from-category")
@AllArgsConstructor
public class ViewProductsFromCategoryController {


    private final  ProductService productService;
    private final  CategoryService categoryService;
    private final  CartService cartService;

    @GetMapping("/{categoryId}")
    public String searchProductByCategory(@PathVariable Long categoryId, Model model) {

        model.addAttribute("products", productService.productsByCategory(categoryService.getById(categoryId)));
        model.addAttribute("categoryId",categoryId);

        return "product/view-products-from-category";
    }

    @PostMapping
    @RequestMapping("/{categoryId}")
    public String viewProductsBySort(Model model, @PathVariable Long categoryId , String type) {

        if (type.equals("increase")) {
            model.addAttribute("products", productService.getProductsByCategoryOrderByPriceAsc(categoryService.getById(categoryId)));
        } else if (type.equals("decrease")){
            model.addAttribute("products", productService.getProductsByCategoryOrderByPriceDesc(categoryService.getById(categoryId)));
        } else if (type.equals("A-Z")){
            model.addAttribute("products", productService.getProductsByCategoryOrderByNameAsc(categoryService.getById(categoryId)));
        }else if (type.equals("Z-A")){
            model.addAttribute("products", productService.getProductsByCategoryOrderByNameDesc(categoryService.getById(categoryId)));
        }

        return "product/view-products-from-category";
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
