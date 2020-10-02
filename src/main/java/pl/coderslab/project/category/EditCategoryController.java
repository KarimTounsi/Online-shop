package pl.coderslab.project.category;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.product.Product;
import pl.coderslab.project.product.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/category/edit")
@AllArgsConstructor
public class EditCategoryController {

    CategoryService categoryService;
    CartService cartService;

    @GetMapping
    public String editCategory(Model model, @RequestParam Long id) {

        Category category = categoryService.getById(id);

        model.addAttribute("category", category);
        return "edit-category";
    }

    @PostMapping
    public String editCategory(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-category";
        }
        categoryService.saveCategory(category);
        return "redirect:/admin/category/all";
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
