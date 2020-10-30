package pl.coderslab.project.product.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.service.CartService;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.dbImage.entity.DbImage;
import pl.coderslab.project.dbImage.service.DbImageService;
import pl.coderslab.project.product.entity.Product;
import pl.coderslab.project.product.service.ProductService;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/product/add")
@AllArgsConstructor
public class AddProductController {

    private final  ProductService productService;
    private final   CategoryService categoryService;
    private final   CartService cartService;
    private final   DbImageService dbImageService;


    @GetMapping
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping
    public String addProduct(@Valid Product product,   BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "product/add-product";
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
