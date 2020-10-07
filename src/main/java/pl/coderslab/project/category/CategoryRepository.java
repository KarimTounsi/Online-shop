package pl.coderslab.project.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByStatusTrue();
    List<Category> findAllByStatus(boolean status);

}
