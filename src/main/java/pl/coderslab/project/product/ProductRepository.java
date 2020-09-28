package pl.coderslab.project.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.project.category.Category;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByNameIsStartingWith(String name);

    List <Product> findProductsByCategory(Category category);

    Optional<Product> findById(Long id);
}
