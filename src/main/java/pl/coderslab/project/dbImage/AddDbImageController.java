package pl.coderslab.project.dbImage;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.project.category.Category;
import pl.coderslab.project.category.CategoryService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/image/add")
@AllArgsConstructor
public class AddDbImageController {

    DbImageService dbImageService;
    CategoryService categoryService;

    @GetMapping
    public String addFile() {
        return "dbImage/add-image";
    }

        @PostMapping
        public String addFile(@RequestPart(name = "file") MultipartFile file
                , @RequestParam(required = false) String fileName) throws IOException {
            DbImage dbImage = new DbImage();
            dbImage.setContentType(file.getContentType());
            dbImage.setSize(file.getSize());
            dbImage.setOriginalImageName(file.getOriginalFilename());
            if (fileName != null && !fileName.isBlank()) {
                dbImage.setImageName(fileName);
            } else {
                dbImage.setImageName(file.getName());
            }
            dbImage.setData(file.getBytes());

            dbImageService.saveFile(dbImage);

            return "redirect:/admin/image/add";
        }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllSorted();
    }




    }


