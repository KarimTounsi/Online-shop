package pl.coderslab.project.category;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.CartService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/category/add")
@AllArgsConstructor
public class AddCategoryController {

    CategoryService categoryService;
    CartService cartService;


    @GetMapping
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "add-category";
    }

    @PostMapping
    public String addCategory(@Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "add-category";
        }

   categoryService.saveCategory(category);
        return "redirect:/admin/category/add";
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
