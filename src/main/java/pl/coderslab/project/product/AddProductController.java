package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;
import pl.coderslab.project.dbImage.DbImage;
import pl.coderslab.project.dbImage.DbImageService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/product/add")
@AllArgsConstructor
public class AddProductController {

    ProductService productService;
    CategoryService categoryService;
    CartService cartService;
    DbImageService dbImageService;


    @GetMapping
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping
    public String addProduct(@Valid Product product,   BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "add-product";
        }

        productService.saveProduct(product);
        return "redirect:/admin/product/add";
    }


    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @ModelAttribute("ProductsInCart")
    public int ProductsInCart() {
        return cartService.getAmountProductsInCart();
    }


    @ModelAttribute("images")
    public List<DbImage>  getAllImagesWithProductRelations() {
        return dbImageService.getAllDbFileWithProductRelations();
    }


}
