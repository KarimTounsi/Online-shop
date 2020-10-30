package pl.coderslab.project.dbImage.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.project.dbImage.service.DbImageService;

@Controller
@RequestMapping("/admin/image/image-without-relations")
@AllArgsConstructor
public class ViewDbImageWithoutRelationsController {

    private final  DbImageService dbImageService;

    @GetMapping
    public String prepareFilesPage(Model model) {
        model.addAttribute("images", dbImageService.getAllDbFileWithProductRelations());
        return "dbImage/view-all-Images";
    }

}
