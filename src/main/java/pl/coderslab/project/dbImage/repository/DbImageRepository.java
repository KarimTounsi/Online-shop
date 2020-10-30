package pl.coderslab.project.dbImage.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.project.dbImage.entity.DbImage;

import java.util.List;

public interface DbImageRepository extends JpaRepository<DbImage, Long> {

    List<DbImage> findAllByContentTypeStartsWith(String mediaType);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = "data")
    DbImage findWithDataById(Long id);


//    @Override
//    List<DbFile> findAllBy;


    @Query( value = "select * from images left join product_images pi on images.id = pi.images_id  where pi.images_id is null order by created_on", nativeQuery = true)
    List<DbImage> findAllDbFileWithProductRelations();

}
