package pl.coderslab.project.category;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.project.product.ProductService;


@Controller
@AllArgsConstructor
public class DeleteCategoryController {

    CategoryService categoryService;



    @PostMapping("/admin/category/delete")
    public String deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/category/all";

    }


    @PostMapping("/admin/category/delete/all")
    public String deleteAllCategories() {
        categoryService.deleteAllCategories();
        return "redirect:/admin/category/all";

    }

}
