//package pl.coderslab.project.dbfile;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@Controller
//@RequestMapping("/files")
//@RequiredArgsConstructor
//public class FileResourceController {
//
//    private final DbFileRepository dbFileRepository;
//
//    @GetMapping
//    public String prepareFilesPage(Model model) {
//        model.addAttribute("files", dbFileRepository.findAllByContentTypeStartsWith("image"));
//        return "files";
//    }
//
//    @GetMapping("/{id:[\\d+]}")
//    public ResponseEntity<Resource> getFile(@PathVariable Long id) {
//        DbFile dbFile = dbFileRepository.findWithDataById(id);
//        ByteArrayResource resource = new ByteArrayResource(dbFile.getData());
//        return ResponseEntity.ok()
//                .contentType(MediaType.valueOf(dbFile.getContentType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION,
//                        // INLINE; FILENAME="user_01_avatar.png"
//                        "INLINE; FILENAME=\"" + dbFile.getFileName() + "\"")
//                .body(resource);
//    }
//
//    @GetMapping("/upload")
//    public String prepareUploadFile() {
//        return "upload";
//    }
//
//    @PostMapping("/upload")
//    @ResponseBody
//    public String uploadFile(@RequestPart(name = "file") MultipartFile file
//    , @RequestParam(required = false) String fileName) throws IOException {
//        DbFile dbFile = new DbFile();
//        dbFile.setContentType(file.getContentType());
//        dbFile.setSize(file.getSize());
//        dbFile.setOriginalFileName(file.getOriginalFilename());
//        if (fileName != null && !fileName.isBlank()) {
//            dbFile.setFileName(fileName);
//        } else {
//            dbFile.setFileName(file.getName());
//        }
//        dbFile.setData(file.getBytes());
//
//        // Ewentualnie dodatkowy kod wiążący plik z użytkownikiem albo czymś innym
//        dbFileRepository.save(dbFile);
//        return String.valueOf(dbFile.getId());
//    }
//
//
//}
