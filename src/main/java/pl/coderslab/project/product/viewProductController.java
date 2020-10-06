package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;
import pl.coderslab.project.dbImage.DbImageService;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class viewProductController {

    ProductService productService;
    CategoryService categoryService;
    CartService cartService;
    DbImageService dbImageService;


    @ModelAttribute("products")
    public List<Product> getAll() {
        return productService.getAll();
    }


    @GetMapping("/{productId}")
    public String viewProducts(@PathVariable Long productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));


        return "view-product";
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
