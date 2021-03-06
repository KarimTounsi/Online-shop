package pl.coderslab.project.category.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.project.category.entity.Category;
import pl.coderslab.project.category.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@AllArgsConstructor
public class RestoreCategoryController {

    private final  CategoryService categoryService;



    @PostMapping("/admin/category/restore")
    public String deleteCategory(@RequestParam Long id) {
       Category category= categoryService.getById(id);
       category.setStatus(true);
       categoryService.saveCategory(category);
        return "redirect:/admin/category/all/deleted";

    }


    @PostMapping("/admin/category/restore/all")
    public String deleteAllCategories() {
        List<Category> list = categoryService.getAllByStatus(false).stream().peek(category -> category.setStatus(true)).collect(Collectors.toList());
        categoryService.saveCategories(list);
        return "redirect:/admin/category/all/deleted";

    }

}
