package pl.coderslab.project.product;



import pl.coderslab.project.category.Category;

import java.util.List;
import java.util.Optional;

public interface ProductService {

   List <Product> findProductsByNameIsStartingWithName(String name);

   List <Product> getAll();

   void saveProduct(Product product);

   List <Product> productsByCategory(Category category);

   Product getProductById(Long id);

   void deleteProductById(Long id);

   void deleteAllProducts();

   Optional<Product> findById(Long id);

   List <Product> getAllByOrderByPriceAsc();

   List <Product> getAllByOrderByPriceDesc();

   List <Product> getAllByOrderByNameAsc();

   List <Product> getAllByOrderByNameDsc();

   List<Product> getProductsByNameIsStartingWithOrderByPriceAsc(String name);

   List<Product> getProductsByNameIsStartingWithOrderByPriceDesc(String name);

   List<Product> getProductsByNameIsStartingWithOrderByNameAsc(String name);

   List<Product> getProductsByNameIsStartingWithOrderByNameDesc(String name);


   List<Product> getProductsByCategoryOrderByPriceAsc(Category category);

   List<Product> getProductsByCategoryOrderByPriceDesc(Category category);

   List<Product> getProductsByCategoryOrderByNameAsc(Category category);

   List<Product> getProductsByCategoryOrderByNameDesc(Category category);

}
