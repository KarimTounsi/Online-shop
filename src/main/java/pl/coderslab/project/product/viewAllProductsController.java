package pl.coderslab.project.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/all")
@AllArgsConstructor
public class viewAllProductsController {

    ProductRepository productRepository;
    CategoryService categoryService;


    @ModelAttribute("products")
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    @GetMapping
    public String viewProducts() {


        return "view-all-products";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

}
