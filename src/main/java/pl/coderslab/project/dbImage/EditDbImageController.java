package pl.coderslab.project.dbImage;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.project.cart.CartService;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;
import java.util.List;

@Controller
@RequestMapping("/admin/image/edit")
@AllArgsConstructor
public class EditDbImageController {


    CartService cartService;
    DbImageService dbImageService;
    CategoryService categoryService;

    @GetMapping
    public String editImage(Model model, @RequestParam Long id) {

        DbImage dbImage = dbImageService.getById(id);

        model.addAttribute("imageName", dbImage.getImageName());
        model.addAttribute("imageId", dbImage.getId());

        return "dbImage/edit-image";
    }

    @PostMapping
    public String editImage(Long id,String imageName) {
        DbImage dbImage = dbImageService.getById(id);
        dbImage.setImageName(imageName);
        dbImageService.saveFile(dbImage);
        return "redirect:/admin/image/image-without-relations";
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }

    @ModelAttribute("ProductsInCart")
    public int ProductsInCart() {
        return cartService.getAmountProductsInCart();
    }


}
