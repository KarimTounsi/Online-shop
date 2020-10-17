package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/admin/product/all/deleted")
@AllArgsConstructor
public class viewAllDeletedProductsController {

ProductService productService;
    CategoryService categoryService;
    CartService cartService;


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
