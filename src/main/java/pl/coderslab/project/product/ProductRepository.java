package pl.coderslab.project.product;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.project.category.Category;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findProductsByStatusTrueAndNameContaining(String name);

    List<Product> findProductsByStatusTrueAndNameIsStartingWithOrderByPriceAsc(String name);

    List<Product> findProductsByStatusTrueAndNameIsStartingWithOrderByPriceDesc(String name);

    List<Product> findProductsByStatusTrueAndNameIsStartingWithOrderByNameAsc(String name);

    List<Product> findProductsByStatusTrueAndNameIsStartingWithOrderByNameDesc(String name);


    List<Product> findProductsByStatusTrueAndCategoryOrderByPriceAsc(Category category);

    List<Product> findProductsByStatusTrueAndCategoryOrderByPriceDesc(Category category);

    List<Product> findProductsByStatusTrueAndCategoryOrderByNameAsc(Category category);

    List<Product> findProductsByStatusTrueAndCategoryOrderByNameDesc(Category category);



    List <Product> findProductsByStatusTrueAndCategory(Category category);


    List <Product> findAllByStatusTrueOrderByPriceAsc();

    List <Product> findAllByStatusTrueOrderByPriceDesc();

    List <Product> findAllByStatusTrueOrderByNameAsc();

    List <Product> findAllByStatusTrueOrderByNameDesc();

    List <Product> findAllByStatusTrueOrderByIdDesc();

    List <Product> findAllByStatus(boolean status);

}
