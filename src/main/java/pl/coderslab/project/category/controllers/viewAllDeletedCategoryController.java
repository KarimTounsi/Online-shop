package pl.coderslab.project.category.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/admin/category/all/deleted")
@AllArgsConstructor
public class viewAllDeletedCategoryController {


    private final  CategoryService categoryService;
    private final  CartService cartService;

    @GetMapping
    public String viewCategories() {

        return "category/view-all-deleted-categories";
    }

    @ModelAttribute("categoriesWithStatusFalse")
    public List<Category> getAllCategoriesStatusFalse() {
        return categoryService.getAllByStatus(false);
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
