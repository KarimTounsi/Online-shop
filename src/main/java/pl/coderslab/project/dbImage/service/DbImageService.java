package pl.coderslab.project.dbImage.service;

import pl.coderslab.project.dbImage.entity.DbImage;

import java.util.List;


public interface DbImageService {

    List<DbImage> getAllByContentTypeStartsWith(String mediaType);

    DbImage getWithDataById(Long id);

    void saveFile(DbImage dbFile);

    List<DbImage> getAllDbFileWithProductRelations();


    DbImage getById(Long id);

    void deleteDbImageById(Long id);

    void deleteAllDbImages();


}
