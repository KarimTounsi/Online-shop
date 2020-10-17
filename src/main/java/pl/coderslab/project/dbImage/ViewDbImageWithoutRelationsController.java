package pl.coderslab.project.dbImage;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/image/image-without-relations")
@AllArgsConstructor
public class ViewDbImageWithoutRelationsController {

    DbImageService dbImageService;

    @GetMapping
    public String prepareFilesPage(Model model) {
        model.addAttribute("images", dbImageService.getAllDbFileWithProductRelations());
        return "dbImage/view-all-Images";
    }

}
