package pl.coderslab.project.dbImage;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.project.category.CategoryService;


@Controller
@AllArgsConstructor
public class DeleteDbImageController {

    CategoryService categoryService;
    DbImageService dbImageService;



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
