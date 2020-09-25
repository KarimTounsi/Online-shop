package pl.coderslab.project.category;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.product.Product;
import pl.coderslab.project.product.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/category/all")
@AllArgsConstructor
public class viewAllCategoryController {


    CategoryService categoryService;

    @GetMapping
    public String viewCategories() {

        return "view-all-categories";
    }



    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }




}
