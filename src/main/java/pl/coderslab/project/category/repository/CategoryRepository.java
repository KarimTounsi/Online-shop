package pl.coderslab.project.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.project.category.entity.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByStatusTrue();
    List<Category> findAllByStatus(boolean status);

}
