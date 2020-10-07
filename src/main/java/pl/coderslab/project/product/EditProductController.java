package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;
import pl.coderslab.project.dbImage.DbImage;
import pl.coderslab.project.dbImage.DbImageRepository;
import pl.coderslab.project.dbImage.DbImageService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/product/edit")
@AllArgsConstructor
public class EditProductController {

    ProductService productService;
    CategoryService categoryService;
    CartService cartService;
 DbImageService dbImageService;


    @GetMapping
    public String editProduct(Model model, @RequestParam Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product";
    }

    @PostMapping
    public String editProduct(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "edit-product";
        }
        productService.saveProduct(product);
        return "redirect:/all";
    }


    @ModelAttribute("images")
    public List<DbImage>  getAllImagesWithProductRelations() {
        return dbImageService.getAllDbFileWithProductRelations();
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
