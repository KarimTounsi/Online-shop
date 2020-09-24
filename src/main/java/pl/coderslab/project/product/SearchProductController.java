package pl.coderslab.project.product;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import java.util.List;


@Controller
@RequestMapping("/search")
@AllArgsConstructor
public class SearchProductController {

    ProductService productService;
    CategoryService categoryService;

    @PostMapping
    public String searchProduct(String search, Model model) {

        model.addAttribute("products", productService.findProductsByNameIsStartingWithName(search));

        return "view-search-products";
    }

//    @PostMapping
//    @ResponseBody
//    public String searchedProduct(@RequestParam  String search) {
//        return productService.findProductsByNameIsStartingWith(search).toString() ;
//    }

    @GetMapping("/{categoryId}")
    public String searchProductByCategory(@PathVariable Long categoryId, Model model) {
        model.addAttribute("products", productService.productsByCategory(categoryService.getById(categoryId)));
        return "view-search-products";
    }


    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

}
