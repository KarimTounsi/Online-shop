package pl.coderslab.project.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.CartService;

import java.util.List;

@Controller
@RequestMapping("/admin/category/all")
@AllArgsConstructor
public class viewAllCategoryController {


    CategoryService categoryService;
    CartService cartService;

    @GetMapping
    public String viewCategories() {

        return "category/view-all-categories";
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
