package pl.coderslab.project.product;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/product/edit")
public class EditProductController {

    ProductService productService;
    CategoryService categoryService;

    public EditProductController(ProductService productService, @Qualifier("categoryServiceImpl") CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

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



    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }


}
