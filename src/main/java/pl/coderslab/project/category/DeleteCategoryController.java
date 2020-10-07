package pl.coderslab.project.category;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.project.product.ProductService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
public class DeleteCategoryController {

    CategoryService categoryService;



    @PostMapping("/admin/category/delete")
    public String deleteCategory(@RequestParam Long id) {
       Category category= categoryService.getById(id);
       category.setStatus(false);
       categoryService.saveCategory(category);
        return "redirect:/admin/category/all";

    }


    @PostMapping("/admin/category/delete/all")
    public String deleteAllCategories() {
        List<Category> list = categoryService.getAllByStatus(true).stream().peek(category -> category.setStatus(false)).collect(Collectors.toList());
        categoryService.saveCategories(list);
        return "redirect:/admin/category/all";

    }

}
