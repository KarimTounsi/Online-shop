package pl.coderslab.project.dbImage.controllers;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.project.category.service.CategoryService;
import pl.coderslab.project.dbImage.service.DbImageService;


@Controller
@AllArgsConstructor
public class DeleteDbImageController {

    private final  CategoryService categoryService;
    private final  DbImageService dbImageService;



    @PostMapping("/admin/image/delete")
    public String deleteCategory(@RequestParam Long id) {
        dbImageService.deleteDbImageById(id);
        return "redirect:/admin/image/image-without-relations";

    }


    @PostMapping("/admin/image/delete/all")
    public String deleteAllCategories() {
        dbImageService.deleteAllDbImages();
        return "redirect:/admin/image/image-without-relations";

    }

}
