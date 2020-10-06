package pl.coderslab.project.dbImage;

import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/image/view")
@AllArgsConstructor
public class ViewDbImageController {

    DbImageService dbImageService;


    @GetMapping("/{id:[\\d+]}")
    public ResponseEntity<Resource> getFile(@PathVariable Long id) {
        DbImage dbImage = dbImageService.getWithDataById(id);
        ByteArrayResource resource = new ByteArrayResource(dbImage.getData());
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(dbImage.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        // INLINE; FILENAME="user_01_avatar.png"
                        "INLINE; FILENAME=\"" + dbImage.getImageName() + "\"")
                .body(resource);
    }
}
