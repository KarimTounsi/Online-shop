package pl.coderslab.project.product;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.project.category.Category;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findProductsByNameIsStartingWith(String name);

    List<Product> findProductsByNameIsStartingWithOrderByPriceAsc(String name);

    List<Product> findProductsByNameIsStartingWithOrderByPriceDesc(String name);

    List<Product> findProductsByNameIsStartingWithOrderByNameAsc(String name);

    List<Product> findProductsByNameIsStartingWithOrderByNameDesc(String name);


    List<Product> findProductsByCategoryOrderByPriceAsc(Category category);

    List<Product> findProductsByCategoryOrderByPriceDesc(Category category);

    List<Product> findProductsByCategoryOrderByNameAsc(Category category);

    List<Product> findProductsByCategoryOrderByNameDesc(Category category);



    List <Product> findProductsByCategory(Category category);


    List <Product> findAllByOrderByPriceAsc();

    List <Product> findAllByOrderByPriceDesc();

    List <Product> findAllByOrderByNameAsc();

    List <Product> findAllByOrderByNameDesc();

    List <Product> findAllByOrderByIdDesc();



}
